import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:03 2019-07-30
 * @ Description：测试通道
 * @ Modified By：
 *
 * 一、通道(Channel):用于源节点与目标节点的连接。在java NIO中负责缓存区中的数据的传输。Channel本身不存储数据,缓冲区存储数据
 * 二、通道的主要实现类
 *    java.nio.channels.Channel
 *    |--FileChannel
 *    |--SocketChannel
 *    |--ServerChannel TCP
 *    |--DatagramChannel UDP
 * 三、获取通道
 *  1.java提供了getChannel()方法
 *    本地IO：
 *    FileInputStream/FileOutputStream
 *    RandomAccessFile
 *
 *    网络IO:
 *    Socket
 *    ServerSocket
 *    DatagramSocket
 *  2.jdk1.7+ NIO添加了针对通道的open()方法    Files工具类的newByteChannel()
 *
 * 四、 通道之间传输
 * transferFrom() test3
 * transferTo()
 *
 * 五、分散(Scatter)读取  聚集(Gather)写入
 * 分散读取(Scattering Reads):将通道中的数据按照顺序分散到多个缓存区
 * 聚集读取(Gather writer):将多个缓存区中的数据聚集到通道中
 */
public class TestChannel1 {


    /**
     * 分散读取和分散写入
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");

        //1.获取通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        //2.指定多个缓存区
        ByteBuffer b1 = ByteBuffer.allocate(10);
        ByteBuffer b2 = ByteBuffer.allocate(100);
        ByteBuffer b3 = ByteBuffer.allocate(1000);
        //3.分散写入
        ByteBuffer[] bufs = {b1,b2,b3};
        fileChannel.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("----------1----------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
        System.out.println("----------2----------------------");
        System.out.println(new String(bufs[2].array(),0,bufs[2].limit()));
        //4.聚集读取
        RandomAccessFile out = new RandomAccessFile("3.txt","rw");
        FileChannel outChannel = out.getChannel();
        outChannel.write(bufs);
    }

    @Test
    public void test3() throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("1.PNG"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.PNG"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        inChannel.transferTo(0,inChannel.size(),outChannel);

        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());

        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        inChannel.read(inMappedBuf);

        outChannel.write(outMappedBuf);
    }


    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.PNG"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.PNG"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //Byte[] b = new Byte[];
    }


}
