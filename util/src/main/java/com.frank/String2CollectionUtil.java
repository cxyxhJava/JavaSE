package com.frank;

import java.util.*;
import java.util.function.Function;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:35 2019-12-17
 * @ Description：
 * @ Modified By：
 */
public class String2CollectionUtil {



    public static void main(String[] args){
        String a = "1,2,3,4,5";

        System.out.println(String2CollectionUtil.string2List(a,",",Long::new));
        System.out.println(String2CollectionUtil.string2List(a,",",Integer::new));



    }

    public static List string2List(String str, String split, Function<String,Object> function){
        List list = new ArrayList();
        String[] strings = str.split(split);
        if (strings.length==0) return list;
        for (String string : strings) {
            list.add(function.apply(string));
        }
        return list;
    }

    public static Set string2Set(String str, String split, Function<String,Object> function){
        Set set = new HashSet();
        String[] strings = str.split(split);
        if (strings.length==0) return set;
        for (String string : strings) {
            set.add(function.apply(string));
        }
        return set;
    }

    public static String list2String(List list, String split){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(
                l->stringBuilder.append(l).append(split)
        );
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public static String set2String(Set set, String split){
        StringBuilder stringBuilder = new StringBuilder();
        set.forEach(
                l->stringBuilder.append(l).append(split)
        );
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

}