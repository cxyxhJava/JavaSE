package com.frank;

/**
 * @author franyang
 * @date 2020/10/26
 */
public class Test {
    public static void main(String[] args) {
        String mainAccount = "390136642";
        long hash = mainAccount.hashCode() & 0x7FFFFFFF;
        System.out.println(hash);
        System.out.println(hash%1024);
        System.out.println(hash%1024/128);
    }
}
po