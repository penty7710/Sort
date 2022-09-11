package com.pty.sort;

import com.pty.swap.*;

/**
 * 选择排序
 * @author : pety
 * @date : 2022/6/25 22:20
 */
public class Select {

    /**
     * 单元选择排序
     */
    public static int [] SelectSort(int [] arr){
        if(arr.length <2){
            return arr;
        }
        int len = arr.length;
        // n - 1 轮次执行,当前 n - 1 个元素排好后，最后一个元素无需执行，故 i < arr.length - 1
        for(int i=0;i<len-1;i++){
            int minIdx = i;
            // 找到本轮执行中最小的元素，将最小值下标赋值给min
            for(int j=i+1;j<len;j++){
                //记录最小的元素的下标
               if(arr[j] < arr[minIdx]){
                   minIdx = j;
               }
            }
            //将最小元素和第一个元素进行交换
            Swap.swap(arr,i,minIdx);
        }
        return  arr;
    }
}
