package com.kkg;

public class Thread13DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(1,"白雪公主");
               g1.start();
               g2.start();
    }

}
class Lipstick{

}
class Mirror{

}
class Makeup extends Thread{
    //static 来保证只有一个公共资源
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeup() throws InterruptedException {
        //不会死锁的代码..
        if (choice==0){
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(200);
            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }
        else{
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(200);
            }
            synchronized (lipstick){
                System.out.println(this.girlName+="获得口红的锁");
            }
     }
        //死锁代码
//        if (choice==0){
//            synchronized (lipstick){
//                System.out.println(this.girlName+="获得口红的锁");
//                Thread.sleep(200);
//                synchronized (mirror){
//                    System.out.println(this.girlName+"获得镜子的锁");
//                }
//            }
//
//        }
//        else{
//            synchronized (mirror){
//                System.out.println(this.girlName+"获得镜子的锁");
//                Thread.sleep(200);
//                synchronized (lipstick){
//                    System.out.println(this.girlName+="获得口红的锁");
//                }
//            }
//        }
    }
}