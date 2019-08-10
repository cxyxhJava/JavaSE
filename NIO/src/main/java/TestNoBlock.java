import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:06 2019-08-01
 * @ Description：TCP NIO发送demo
 * @ Modified By：
 */
public class TestNoBlock {


    @Test
    public void client() throws IOException {
        //1.生成通道  连接服务器
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
        //2.生成缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3.切换为非租塞模式
        socketChannel.configureBlocking(false);

        //4.发送数据到通道
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            byteBuffer.put(("frank    "+LocalDateTime.now().toString()+"\n"+scanner.next()).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //5.获取通道内数据
        while (socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println(LocalDateTime.now().toString()+new String(byteBuffer.array(),0,byteBuffer.limit()));
            byteBuffer.clear();
        }

        socketChannel.close();
    }

    @Test
    public void server() throws IOException {

        //1.创建通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.绑定
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //3.设置为非堵塞
        serverSocketChannel.configureBlocking(false);
        //4.绑定选择器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //5.获取选择器上准备就绪的事件
        while (selector.select()>0){
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while (selectionKeys.hasNext()) {
                //6.获取准备就绪的事件
                SelectionKey selectionKey = selectionKeys.next();
                if (selectionKey.isAcceptable()) {
                    //接收事件就绪的事件  -- 》 生成通道并绑定读取事件
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //读取事件就绪的事件  获取通道内数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int len = 0;
                    while ((len = socketChannel.read(byteBuffer)) >0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                        //要做聊天 可以吧这个信息 发给客户聊天的人  现在直接发会给客户
                        byteBuffer.put(("服务端    "+LocalDateTime.now().toString()+"\n"+"成功接收消息").getBytes());
                        socketChannel.write(byteBuffer);
                    }
                }
                selectionKeys.remove();
            }
        }


    }


    public static void main(String[] args) throws IOException {
        TestNoBlock testNoBlock = new TestNoBlock();
        testNoBlock.client();
    }

}
