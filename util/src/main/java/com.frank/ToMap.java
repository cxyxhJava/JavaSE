package com.frank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author franyang
 * @date 2020/8/20
 * 解决toMap key重复问题
 * java.lang.IllegalStateException: Duplicate key 1
 */
public class ToMap {

    public static void main(String[] args) {


        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User(i,"name"+i);
            userList.add(user);
        }

        try {
            userList.add(new User(1,"你好"));
            Map<Integer,String> map2 = userList.stream().collect(Collectors.toMap(User::getId,User::getName));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("有相同key会报错"+e.getMessage());
        }

        Map<Integer,String> map3 = userList.stream().collect(Collectors.toMap(User::getId,User::getName,(e1, e2) -> e1));
        for (Map.Entry<Integer, String> integerStringEntry : map3.entrySet()) {
            System.out.println("Mp3 key:"+integerStringEntry.getKey()+" value:"+integerStringEntry.getValue());
        }

        Map<Integer,String> map4 = userList.stream().collect(Collectors.toMap(User::getId,User::getName,(e1, e2) -> e2));
        for (Map.Entry<Integer, String> integerStringEntry : map4.entrySet()) {
            System.out.println("Mp4 key:"+integerStringEntry.getKey()+" value:"+integerStringEntry.getValue());
        }




    }

    static class User{
        public User() {
        }

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        private Integer id;

        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
