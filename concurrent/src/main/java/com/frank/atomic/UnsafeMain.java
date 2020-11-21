package com.frank.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author franyang
 * @date 2020/10/12
 */
public class UnsafeMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //Unsafe unsafe = Unsafe.getUnsafe();
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");

        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        //创建对象实例
        TestUnSafe testUnSafe = (TestUnSafe)unsafe.allocateInstance(TestUnSafe.class);
        //操作对象的属性
        Field nameField = TestUnSafe.class.getDeclaredField("name");
        Field ageField = TestUnSafe.class.getDeclaredField("age");
        long name = unsafe.objectFieldOffset(nameField);
        long age = unsafe.objectFieldOffset(ageField);

        System.out.println(name);
        System.out.println(age);

        //操作数组








    }

}

class TestUnSafe{
    private String name;
    private Integer age;

}
