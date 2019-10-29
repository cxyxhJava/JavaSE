package com.frank.lambdas;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:58 2019-10-18
 * @ Description：
 * @ Modified By：
 */
public class Test1 {



    public static void main(String[] args){

        Test t = new Test(){
            @Override
            public Integer test(Integer x, Integer y) {
                return x+y;
            }
        };
        System.out.println(t.test(1,2));

        Test t2 = (Integer x,Integer y) -> x+y ;
        System.out.println(t2.test(1,2));

        Test t3 = (x,y) -> x+y;
        System.out.println(t3.test(1,2));

    }

}
