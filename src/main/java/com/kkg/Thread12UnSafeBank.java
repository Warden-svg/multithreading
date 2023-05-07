package com.kkg;

public class Thread12UnSafeBank

{
    public static void main(String[] args) {
        Account account = new Account(2000,"小明");
        Drawing me = new Drawing(account,1100,"我");
        Drawing girlfriend = new Drawing(account,1000,"女友");
        Thread t1 = new Thread(me,"小明");
        Thread t2 = new Thread(girlfriend,"小明");
        t1.start();
        t2.start();
    }
}
class Account   {
    int money;
    String name;
    public  Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}

 class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

     public Drawing(Account account, int drawingMoney, String name) {
         super(name);
         this.account=account;
         this.drawingMoney = drawingMoney;

     }

     @Override
     public void run() {
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
//         super.run();
         if(account.money-drawingMoney<0){
             System.out.println(Thread.currentThread().getName()+"银行卡余额不足,无法取钱");
             return;
         }
         account.money = account.money-drawingMoney;
         nowMoney = nowMoney+drawingMoney;
         System.out.println("银行卡余额为"+account.money);
         //这里的this.getname==Thread.getCurrentThread().getName;
         System.out.println(this.getName()+"我手里有"+nowMoney);
     }
 }