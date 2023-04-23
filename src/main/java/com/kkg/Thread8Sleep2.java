package com.kkg;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时 //并为创建线程实例
public class Thread8Sleep2 {


    public static void main(String[] args) {
        Date startDate = new Date(System.currentTimeMillis());
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
           startDate = new Date(System.currentTimeMillis());
        }
    }
}
