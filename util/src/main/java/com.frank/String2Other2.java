package com.frank;

import cn.hutool.core.lang.func.Func;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:12 2019-12-17
 * @ Description：
 * @ Modified By：
 */
public class String2Other2 {

    public static void main(String[] args){
        String a = "1,2,3,4,5";
        System.out.println(String2Other2.test(a,Test2Class::test));
        System.out.println(String2Other2.test(a,Long::new));
    }

    public static Set test(String a, Function<String,Object> function){
        String[] strings = a.split(",");
        Set set = new HashSet();
        if (strings.length==0){
            return set;
        }

        for (String s : strings) {
            set.add(function.apply(s));
        }
        return set;
    }
}

class Test2Class{
    public static <T> T test(String a){
        return (T) a;
    }
}




