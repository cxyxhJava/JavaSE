package test2;


/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:44 2019-11-28
 * @ Description：
 * @ Modified By：
 */
public class SourceTestMain {

    public static void main(String[] args) throws Exception {
        System.out.println("开始插入式注解测试");

        test();
    }

    @SourceTest(value = "测试编译器注解")
    public static void test()throws Exception{
    }
}
