package com.pty.sort;

/**
 * 归并排序
 * @author : pety
 * @date : 2022/6/25 23:00
 */
public class Merge {

    public static int [] mergeSort(int [] arr){
        if(arr.length < 2){
            return arr;
        }
        int len = arr.length;
        mergeSort(arr,0,len-1);
        return arr;
    }

    private static void mergeSort(int [] arr,int left,int right){
        if (left < right){
            int mid = left + (right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    //自顶向下非原地归并
    private static void merge(int [] arr,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        //设置一个临时数组，用于存储合并后的元素
        int [] temp = new int[right - left+1];
        int t =0;
        while(i<=mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }else{
                temp[t++] = arr[j++];
            }
        }
        //如果i<=mid,说明j == right，此时前一部分还有元素，直接赋值
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        //如果j<=right,说明i == mid，此时后一部分还有元素，直接赋值
        while(j<=right){
            temp[t++] = arr[j++];
        }
        //将合并后的元素拷贝回原数组
        for(i=0;i<t;i++){
            arr[left++] = temp[i];
        }
    }
}
