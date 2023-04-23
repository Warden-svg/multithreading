package com.kkg;
//龟兔赛跑
public class Thread5 implements Runnable {
    static String winner=null;
    boolean flag;
     int i=1;
    @Override
    public void run() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true){
            i++;
            gameOver(i);
            if (i>=100) {
                winner = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName()+"赢了");
                break;
            }
        }
    }
    public boolean gameOver(int steps){
        if(winner!=null)
            return true;

        System.out.println(Thread.currentThread().getName()+"走了"+i+++"步");
        if(steps>50&&Thread.currentThread().getName().equals("兔子"))
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        return false;
    }

    public static void main(String[] args) {
    Thread5 thread5 = new Thread5();
    new Thread(thread5,"乌龟").start();
    new Thread(thread5,"兔子").start();
    }
}
