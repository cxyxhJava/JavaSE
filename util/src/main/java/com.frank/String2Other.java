package com.frank;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:12 2019-12-17
 * @ Description：
 * @ Modified By：
 */
public class String2Other<T> {
    public static void main(String[] args) {
//        String[] items = split(token);
//        if (items != null) {
//            this.vendorAppKey = items[0];
//            this.vendorNick = items[1];
//            this.buyerAppKey = items[2];
//            this.buyerNick = items[3];
//        }
    }
//
//    public static void main(String[] args){
//        String a = "2|3|4|5|6";
//        String2Other<String> setUtil = new String2Other();
//        System.out.println(setUtil.test(a));
//
//        String2Other<Integer> setUtil2 = new String2Other();
//        System.out.println(setUtil2.test(a));
//
//        String2Other<Long> setUtil3 = new String2Other();
//        System.out.println(setUtil3.test(a));
//
//
//        System.out.println(setUtil3.test2(a,testClass::test));
//
//
//    }
    public Set<T> test(String a){
        Set<T> set = new HashSet<>();
        String[] strings = a.split("\\|");
        if (strings.length==0){
            return set;
        }
        for (String string : strings) {
            set.add((T) string);
        }
        return set;
    }

    public Set<T> test2(String a, Function<String,T> function){
        Set<T> set = new HashSet<>();
        String[] strings = a.split("\\|");
        if (strings.length==0){
            return set;
        }
        for (String string : strings) {
            set.add(function.apply(string));
        }
        return set;
    }

}
class testClass<T> {
    static <T> T test(String a){
        return (T) a;
    }
}