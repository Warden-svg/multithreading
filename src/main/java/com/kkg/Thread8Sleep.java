package com.kkg;
//模拟网络延时,放大问题的发生性
//运行后发现多个人会抢同一张票,有时还会出现负数
public class Thread8Sleep implements Runnable{
    int ticketNums=10;
    @Override
    public void run() {
        while (ticketNums>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        Thread4 thread4 = new Thread4();
        new Thread(thread4,"小明").start();
        new Thread(thread4,"老师").start();
        new Thread(thread4,"黄牛党").start();
    }
}

