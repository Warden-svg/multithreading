package com.kkg;

import org.w3c.dom.ls.LSOutput;
//开启线程的第二种方法,推荐使用
public class Thread3 implements Runnable{
    @Override
    public void run() {
for (int i = 1;i<200;i++)
        System.out.println("我在学习多线程"+i);

    }

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        Thread t = new Thread(thread3);
        t.start();
        for(int i=1;i<500;i++)
            System.out.println("我在吃饭"+i);
    }


}
