import org.junit.jupiter.api.Test;

import java.nio.*;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:06 2019-07-30
 * @ Description：测试缓存区
 * @ Modified By：
 *
 *
 *
 * 缓存区
 *  java.nio中有所有基础类型的buff 除了Boolean
 *  |-- ByteBuffer
 *  |-- CharBuffer
 *  |-- IntBuffer
 *  |-- FloatBuffer
 *  |-- DoubleBuffer
 *
 * 通过allocate获取缓存区
 * 通过allocateDirect获取 零拷贝缓存区(获取物理内存作为缓存区)
 * put()保存
 * flip()切换个为读取模式  position移动到下标0
 * get()获取
 * clear()数据未清除还是可以获取 只是清除limit值
 *
 */
public class TestBuff {


    @Test
    public void test1(){

        String str = "abdce";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("------------创建-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());
       // System.out.println("compact:"+byteBuffer.compact());

        byteBuffer.put(str.getBytes());
        System.out.println("------------put()-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());
      //  System.out.println("compact:"+byteBuffer.compact());

        byteBuffer.flip();
        System.out.println("------------flip()-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());
     //   System.out.println("compact:"+byteBuffer.compact());

        byteBuffer.get();
        System.out.println("------------get()-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());
      //  System.out.println("compact:"+byteBuffer.compact());


        byteBuffer.clear();
        System.out.println("------------clear()-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());
      //  System.out.println("compact:"+byteBuffer.compact());

        System.out.println(byteBuffer.get(0));

        byteBuffer.flip();
        System.out.println("------------flip()-----------");
        System.out.println("limit:"+byteBuffer.limit());
        System.out.println("position:"+byteBuffer.position());
        System.out.println("capacity:"+byteBuffer.capacity());

    }

}
