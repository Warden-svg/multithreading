package com.kkg;

public class Thread10Join implements Runnable{
    public static void main(String[] args) throws InterruptedException {
      Thread10Join thread10Join = new Thread10Join();
      Thread t = new Thread(thread10Join,"线程1");

      for (int i = 0;i<1000;i++)
        {
            if(i==200){
                t.start();
                t.join();}
            System.out.println(Thread.currentThread().getName()+i+"运行");
        }
    }

    @Override
    public void run() {
        for (int i=0;i<200;i++)
        System.out.println(Thread.currentThread().getName()+i+"运行");
    }
}
