package com.frank.completableFuture;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Supplier;

/**
 * @author franyang
 * @date 2020/9/24
 * 3.CompletableFuture 的方法主要有以下几个特点：
 *      （1）以Async结尾的方法都是异步执行的
 *      （2）以run开头的方法一般无返回值，而已supply开头的方法是有返回值的，如 runAsync 和supplyAsync
 *      (3)   以 then 开头的方法都会在上一个任务执行结束之后执行下一个任务。如 thenApply 和 thenAccept
 *      （4）以Accept结尾的方法均为消耗上个任务执行的结果，无返回值。
 *      （5）以run开头的方法忽略上个任务的执行结果，在上个任务执行结束后执行下个方法。
 *      （6）以Executor 结尾的方法可以自定义线程池，如果没有指定线程池，则会默认在ForkJoinPool.commonPool() 线程池中执行。
 */
public class CompletableFutureMain {

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureMain main = new CompletableFutureMain();

      //  main.runAsync();

       // main.supplyAsync("frank");

        main.all("all");

    }


    /**
     * 执行异步
     */
    public void runAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello");
        });
        System.out.println("--------------");
        try {
            future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  执行异步 有返回值
     */
    public void supplyAsync(String x){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                String result = "Hello"+ x;
                return result;
            }
        }
        );
        System.out.println("-------------");
        try {
            String s = future1.get();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void all(String x) throws InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    System.out.println("2222");
                    System.out.println("4444");
                    Thread.sleep(1000l);
                    List<Integer> a = new ArrayList<>();
                    //Thread.sleep(1000l);
                    System.out.println("3333");
                    for (int i=100;i<1000;i++) {
                        a.add(i);
                    }
                    for (Integer integer : a) {
                        System.out.println(integer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String result = "Hello"+ x;
                System.out.println("11111");
                return result;
            }
        });
        System.out.println("------------- supplyAsync");

        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            List<Integer> a = new ArrayList<>();
            for (int i=0;i<100;i++) {
                a.add(i);
            }
            for (Integer integer : a) {
                System.out.println(integer);
            }
            System.out.println("Hello");
        });
        System.out.println("-------------- runAsync");
        try {
            future.get();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s = future1.get();
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }

        Thread.sleep(23000l);

        System.out.println("all over");
    }






}

