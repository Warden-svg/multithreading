package com.kkg;
public class DayOne {
    static int i = 100;
    String s="ddddd";
    public void descend(){
        i=i-10;
        System.out.println(i);
        s=s+"aaaaa";
        System.out.println(s);
    }

    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        DayOne dayOne1 = new DayOne();
        dayOne.descend();
        dayOne1.descend();
        System.out.println(i);
    }
}
