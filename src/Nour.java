package com.sda5.todoapp;

import java.util.ArrayList;

public class Nour
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("the list is: " + list);

        int[] arr =  new int[]{1,2,3};
        System.out.println("the arr is: " + arr);

        Task tt = new Task("tit", null, true, "pro");
        System.out.println(tt);



    }
}
