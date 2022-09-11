package com.pty.swap;

/**
 * @author : pety
 * @date : 2022/6/25 22:02
 */
public class Swap {

    /**
     * 借助中间变量实现交换
     */
    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 借助加减运算实现交换
     */
    public static  void swapCal(int [] arr,int i,int j){
        if(i == j){
            return ;
        }
        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    }

    /**
     * 借助异运算或实现交换
     */
    public static void swapXOR(int [] arr,int i,int j){
        if(i == j){
            return ;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
