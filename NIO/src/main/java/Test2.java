/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:12 2019-08-10
 * @ Description：
 * @ Modified By：
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("你是什么东西");
                    }
                }
        );
        thread.start();


        System.out.println("你不是东西");

        Thread t2 = new Thread(
                ()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("aaaaaaa");
                }
        );
        t2.start();
        while (true){
            Thread.sleep(2000);
            System.out.println("我是猪");
        }
    }


}
