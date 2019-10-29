package com.frank;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 10:34 2019-10-25
 * @ Description：测试Volatile
 * @ Modified By：
 */
public class TestVolatile {

    public static void main(String[] args){



    }

}

class ThreadDemo implements Runnable{
    private boolean flag = false;

    public void run(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+isFlag());
    }

    public boolean isFlag(){
        return flag;
    }

}
