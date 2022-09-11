package com.pty.sort;

import com.pty.swap.*;

/**
 * 冒泡排序
 * @author : pety
 * @date : 2022/6/25 22:07
 */
public class Bubble {

    /**
     * 基础的冒泡排序
     * @param arr
     * @return
     */
    public static int [] bubbleSort(int [] arr){
        if(arr.length <2){
            return arr;
        }
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-1-i;j++){
                if(arr[j] > arr[j+1]){
                    Swap.swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡提前优化：如果有一轮遍历没有元素进行交换，说明元素已经有序，不需要在进行后面的交换
     */
    public int[] bubbleSort1(int [] arr){
        if(arr.length <2){
            return arr;
        }
        int len = arr.length;
        //n - 1轮次执行，当前 n - 1 个元素排好后，最后一个元素无需执行
        //循环len-1轮，每轮循环len-i次
        for(int i=0;i<len-1;i++){
            // 本轮执行是否有交换的标志，若无则false，若有则true
            boolean swapped = false;
            for(int j=1;j<len-i;j++){
                // 若左大于右则交换，并将swapped置为true
                if(arr[j-1] > arr[j]){
                    Swap.swap(arr,j-1,j);
                    swapped = true;
                }
            }
            // 若无交换，表示当前数组已完全排序，退出大循环
            if(!swapped){
                break;
            }
        }
        return arr;
    }


    /**
     * 提前优化+冒泡界优化：利用lastSwappedIdx，不用每一次都遍历len-i个元素，只需遍历到还不是有序的位置即可
     */
    public int [] bubbleSort2(int [] arr){
        if(arr.length <2){
            return arr;
        }
        int len = arr.length;
        //最后一个交换的位置，这个位置后面的元素是有序的
        int lastSwappedIdx = len-1;
        int swappedIdx = -1;
        boolean swapped = true;
        while(swapped){
            // 本轮执行是否有交换的标志，若有则true，若无则false
            swapped = false;
            // 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
            for(int i=0;i<lastSwappedIdx;i++){
                // 若左大于右则交换，并将swapped置为true,并记录当前交换的位置
                if(arr[i] > arr[i+1]){
                    Swap.swapCal(arr,i,i+1);
                    swapped = true;
                    swappedIdx = i;
                }
            }
            lastSwappedIdx = swappedIdx;
        }
        return arr;
    }
}
