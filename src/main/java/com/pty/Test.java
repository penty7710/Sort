package com.pty;

import com.pty.sort.*;

import java.util.Random;

/**
 * @author : pety
 * @date : 2022/9/11 15:09
 */
public class Test {
    public static void main(String[] args) {
        int [] a = new int[200000];
        int len = a.length;
        Random r = new Random();
        for(int i=0;i<len;i++){
            a[i] = r.nextInt(210000);
        }
        long l = System.currentTimeMillis();
        //Bubble.bubbleSort(a);
        //Select.SelectSort(a);
        //Insert.insertSort(a);
        //ShellSort.shellSort(a);
        //Merge.mergeSort(a);
        //Quick.quickSort(a);
        Heap.heapSort(a);

        for(int i=0;i<len;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis()-l);
    }
}
