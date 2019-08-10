import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 10:45 2019-08-02
 * @ Description：管道发送消息
 * @ Modified By：
 */
public class TestPipe {

    @Test
    public void test1() throws IOException {
        //1.获取管道
        Pipe pipe = Pipe.open();
        //2.缓冲区数据写入管道
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        byteBuffer.put("通过单向管道发送数据".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);
        byteBuffer.clear();

        //3。读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        int len = sourceChannel.read(byteBuffer);
        System.out.println("limit:"+new String(byteBuffer.array(),0,byteBuffer.limit()));
        System.out.println("len:"+new String(byteBuffer.array(),0,len));

        sourceChannel.close();
        sinkChannel.close();

    }

}
