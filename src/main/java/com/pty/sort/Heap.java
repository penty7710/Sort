package com.pty.sort;
import com.pty.swap.*;
/**
 * 堆排序
 * @author : pety
 * @date : 2022/9/11 15:52
 */
public class Heap {

    public static void heapSort(int [] arr){
        if(arr.length <2){
            return;
        }
        int len = arr.length;
        //构建大顶堆
        buildMaxHeap(arr,len-1);

        for(int i= len-1;i>=1;i--){
            //交换堆顶和堆底元素
            Swap.swap(arr,0,i);
            adjustHeap(arr,0,i-1);
        }
    }

    /**
     * 构建大顶堆
     * @param arr
     * @param len
     */
    public static void buildMaxHeap(int [] arr,int len){
        for(int i = (len-1)/2;i>=0;i--){
            adjustHeap(arr,i,len);
        }
    }

    /**
     * 下沉操作
     * @param arr
     * @param parent
     * @param len
     */
    public static void adjustHeap(int [] arr,int parent,int len){
        int temp = arr[parent];
        int child = parent*2+1;

        while(child <= len){
            if(child+1 <=len && arr[child] < arr[child+1]){
                child++;
            }

            if(arr[child] <= temp){
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = 2*parent+1;
        }
        arr[parent] = temp;
    }
}
