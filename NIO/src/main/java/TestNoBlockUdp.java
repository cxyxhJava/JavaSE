import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 10:28 2019-08-02
 * @ Description：UDP的NIO传输代码demo
 * @ Modified By：
 */
public class TestNoBlockUdp {


    @Test
    public void client() throws IOException {
        //1.通道
        DatagramChannel datagramChannel = DatagramChannel.open();
        //2.切换非堵塞
        datagramChannel.configureBlocking(false);
        //3.缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4.获取数据
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            byteBuffer.put(("frank    "+ LocalDateTime.now().toString()+"\n"+scanner.next()).getBytes());
            byteBuffer.flip();
            datagramChannel.send(byteBuffer,new InetSocketAddress("127.0.0.1",8080));
            byteBuffer.clear();
        }

        //5.获取通道内数据
        while (datagramChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            System.out.println(LocalDateTime.now().toString()+new String(byteBuffer.array(),0,byteBuffer.limit()));
            byteBuffer.clear();
        }

        datagramChannel.close();

    }


    @Test
    public void server() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);

        datagramChannel.bind(new InetSocketAddress(8080));

        Selector selector = Selector.open();

        datagramChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select()>0){
           Iterator<SelectionKey> iterator =  selector.selectedKeys().iterator();
           while (iterator.hasNext()){
               SelectionKey selectionKey = iterator.next();
               if (selectionKey.isReadable()){
                   DatagramChannel dc = (DatagramChannel) selectionKey.channel();
                   ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                   dc.receive(byteBuffer);
                   byteBuffer.flip();
                   System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
               }
              iterator.remove();
           }
        }
    }

    public static void main(String[] args) throws IOException {
        TestNoBlockUdp testNoBlockUdp = new TestNoBlockUdp();
        testNoBlockUdp.client();
    }
}
