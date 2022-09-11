package com.pty.sort;
import com.pty.swap.*;

import java.util.Random;


/**
 * @author : pety
 * @date : 2022/9/11 15:27
 */
public class Quick {

    public static void quickSort(int [] arr){
        if(arr.length <2){
            return;
        }
        int len = arr.length;
        quickSort(arr,0,len-1);
    }

    /**
     * 随机基准数
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int [] arr,int left,int right){
        if(left < right){
            int randomIndex = new Random().nextInt(right-left)+left+1;
            Swap.swap(arr,left,randomIndex);
            int mid = patition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    /**
     * 选取第一个为基准数
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort1(int [] arr,int left,int right){
        if(left < right){
            int mid = patition1(arr,left,right);
            quickSort1(arr,left,mid-1);
            quickSort1(arr,mid+1,right);
        }
    }


    /**
     * 对基准数排序
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int patition(int [] arr,int left ,int right){
        int pivot = left;
        int index = left+1;
        for(int i = index;i<=right;i++){
            if(arr[i] < arr[pivot]){
                //交换两个数
                Swap.swap(arr,index,i);
                index++;
            }
        }
        Swap.swap(arr,index-1,left);
        return index-1;
    }

    public static int patition1(int [] arr,int left,int right){
        int pivot =arr[left];
        int i = left+1;
        int j = right;

        while(true){
            while(i<=j && arr[i] <= pivot){
                i++;
            }

            while(i<=j && arr[j] >= pivot){
                j--;
            }
            if(i>=j){
                break;
            }
            Swap.swap(arr,i,j);
        }
        Swap.swap(arr,left,j);
        return j;
    }
}
