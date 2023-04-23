package com.kkg;
//通过外部标志位来停止线程,推荐使用这种方法,jdk中的stop方法已废弃,不建议使用
public class Thread7Stop implements Runnable{
    private  boolean flag = true;
    @Override
    public void run() {
        int i=0;
        while(flag){

            System.out.println("run thread"+i++);
        }
    }
    public void stop(){
        this.flag=false;
    }
    public static void main(String[] args) {
        Thread7Stop threadStop = new Thread7Stop();
        new Thread(threadStop,"stop").start();
        for (int i=0;i<200;i++){
            System.out.println("主线程现在是"+i);
            if (i==90)
            {
                threadStop.stop();
            System.out.println("threadStop线程已停止");
            }
        }
    }
}
