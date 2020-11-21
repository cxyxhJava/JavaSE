package com.frank.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author franyang
 * @date 2020/10/12
 */
public class Atomic {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.addAndGet(1));
        System.out.println(atomicInteger.getAndAdd(1));
        System.out.println(atomicInteger.getAndSet(2));
        atomicInteger.set(2);
        System.out.println(atomicInteger.get());
    }

}
