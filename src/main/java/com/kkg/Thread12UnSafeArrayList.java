package com.kkg;

import java.util.ArrayList;

//线程不安全例子3  多个线程可能会同时对arraylist中的同一项进行写入,导致覆盖源数据,最后结果不是10000
public class Thread12UnSafeArrayList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0;i<=10000;i++)
        {
            new Thread(()->{
                arrayList.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(arrayList.size());
    }
}
