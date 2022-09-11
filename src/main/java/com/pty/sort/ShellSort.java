package com.pty.sort;

/**
 * @author : pety
 * @date : 2022/6/25 22:45
 */
public class ShellSort {

    public static int [] shellSort(int [] arr){
        if(arr.length <2){
            return arr;
        }
        int len = arr.length;
        int gap = len/2;

        while(gap >0){
            for(int i=gap;i<len;i++){
                int current = arr[i];
                int preindex = i-gap;
                while(preindex>=0 && arr[preindex] > current){
                    arr[preindex+gap] = arr[preindex];
                    preindex-=gap;
                }
                arr[preindex+gap] = current;
            }
            gap/=2;
        }
        return arr;
    }
}
