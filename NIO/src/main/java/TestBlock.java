import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:18 2019-08-01
 * @ Description：
 * @ Modified By：
 */
public class TestBlock {
    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {

        //1.生成通道 客户端用的通道  连接对应的服务器
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));

        FileChannel fileChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);
        //2.创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(10240);

        //3.数据写入通道
        while (fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println("--------输入写入缓冲区");
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //关闭连接
        socketChannel.shutdownOutput();
        //接收服务端反馈
        while (socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println("--------服务端反馈");
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
            byteBuffer.clear();
        }
        byteBuffer.clear();
        fileChannel.close();
        socketChannel.close();
    }


    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        //服务端用的通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
        byteBuffer.put(("服务端接收成功"+ LocalDateTime.now().toString()).getBytes());

        //获取通道内的数据
        while (socketChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println("-------获取客户端数据");
            System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
            byteBuffer.clear();
        }

        byteBuffer.put(("服务端返回"+LocalDateTime.now().toString()).getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        socketChannel.close();
        serverSocketChannel.close();
        byteBuffer.clear();



    }

}
