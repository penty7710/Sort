package com.pty.sort;

/**插入排序
 * @author : pety
 * @date : 2022/6/25 22:32
 */
public class Insert {

    public static int[] insertSort(int[] arr) {
        if (arr.length < 2){
            return arr;
        }
        int len = arr.length;
        for(int i=1;i<len;i++){
            //当前元素
            int current = arr[i];
            //前一个下标
            int preindex = i-1;
            while(preindex>=0 && arr[preindex] > current){
                arr[preindex+1] = arr[preindex];
                preindex--;
            }
            arr[preindex+1] = current;
        }
        return arr;
    }
}
