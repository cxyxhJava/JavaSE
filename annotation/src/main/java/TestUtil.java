/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 19:21 2019-11-15
 * @ Description：测试注解用的类
 * @ Modified By：
 */
public class TestUtil {

    @TestUseCases(id = 11, desc = "test1")
    public void test1(){
        return ;
    }


    @TestUseCases(id = 12)
    public String test2(String name){
        return name;
    }




}
