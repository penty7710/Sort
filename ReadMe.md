# 排序算法

## 概念

>- **稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
>
>- **不稳定**：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；
>- **原地排序**：在排序过程中不申请多余的存储空间，只利用原来存储待排数据的存储空间进行比较和交换的数据排序；
>- **非原地排序**：需要利用额外的数组来辅助排序；

**各排序算法总结：**

![image-20220911004032768](https://pety.oss-cn-shenzhen.aliyuncs.com/img/image-20220911004032768.png)



## 冒泡排序

>冒泡排序是一种简单的排序算法，每轮比较，将未排序的最大的数字放到最后，经过n-1轮，整个数组都有序了。
>
>- 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
>- 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
>- 针对所有的元素重复以上的步骤，除了最后一个；
>- 重复步骤1~3，直到排序完成。

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/aHR0cHM6Ly9pbWFnZXMyMDE3LmNuYmxvZ3MuY29tL2Jsb2cvODQ5NTg5LzIwMTcxMC84NDk1ODktMjAxNzEwMTUyMjMyMzg0NDktMjE0NjE2OTE5Ny5naWY.gif)

```java
/**
 * 冒泡排序
 * @param a
 * @return
 */
public static int [] BubbleSort(int [] a){
    if(a.length == 0)
        return a;
    int len = a.length;
    for(int i=0;i<len;i++){
        for(int j=0;j<len-i-1;j++){
            //交换两个相邻数字
            if(a[j+1]<a[j]){
                int temp = a[j+1];
                a[j+1] = a[j];
                a[j] = temp;
            }
        }
    }
    return a;
}
```



**优化一下冒泡排序的算法**

>如果某一趟的遍历中，相邻的元素之间都没有发生交换的操作，这意味着右边的元素总是大于等于左边的元素，此时的数组已经是有序的了，我们无需再对剩余的元素重复比较下去了。

```java
 public static int[] bubbleSort(int[] arr) {
         if ( arr.length == 0) {
             return arr;
         }
         int len = arr.length;
         for (int i = 0; i < len; i++) {
             boolean flag = true;
             for (int j = 0; j < len -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = false;
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
            //一趟下来是否发生位置交换
            if(false)
                break;
        }
        return arr;
    }
```

**使用优化后的冒泡算法，在数组本身就有序的情况下，时间复杂度为O(n)**



## 选择排序

>将数组分为已经排序和未排序两部分，初始时已排序部分元素个数为0。每次遍历，找到未排序数组中的最小元素，然后将它放在已排序数组中的末尾。经过n-1次遍历后，整个数组就是有序的了。
>
>- 初始状态：无序区为R[1…n]，有序区为空；
>- 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。该趟排序从当前无序区中选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
>- n-1趟结束，数组有序化了

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/2.gif)

```java
/**
     * 选择排序
     * @param a
     * @return
     */
    public static int [] SelectSort(int [] a){
        if(a.length == 0)
            return a;
        int len = a.length;
        for(int i=0;i<len;i++){
            int minindex = i;
            //遍历无序数组，找到最小的元素
            for(int j=i+1;j<len;j++){
                if(a[j] < a[minindex])
                    minindex = j;
            }
			//交换元素
            int temp = a[i];
            a[i] = a[minindex];
            a[minindex] = temp;
        }
        return a;
    }
```



## 插入排序

>插入排序同样将数组分为已排序和未排序的两部分。每次遍历的时候都将当前元素和之前的元素进行比较，找到小于等于自己的元素，然后插入到他的后面；在比较过程中，大于当前元素的元素都将向后移动一位。
>
>- 从第一个元素开始，该元素可以认为已经被排序；
>- 取出下一个元素，在已经排序的元素序列中从后向前扫描；
>- 如果该元素（已排序）大于新元素，将该元素移到下一位置；
>- 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
>- 将新元素插入到该位置后；
>- 重复步骤2~5。

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/3.gif)

```Java
/**
 * 插入排序
 * @param a
 * @return
 */
public static int [] insertSort(int [] a){
    if(a.length == 0)
        return a;
    int len = a.length;
    for(int i=1;i<len;i++){
        //当前元素
        int current = a[i];
        //前一个元素的位置
        int preindex = i-1;

        while(preindex>=0&&a[preindex] > current){
            //将大于当前元素的值向后移动一位
            a[preindex+1] = a[preindex];
            preindex--;
        }
        //退出循环是因为preindex<0 或者 a[preindex] <= current
        //也就是说当前元素应该插入到preindex后面，所以+1
        a[preindex+1] = current;
    }
    return a;
}
```



## 希尔排序

> 希尔排序是插入排序的改进版，也叫缩小增量排序；插入排序每次只会和前面一个数字进行比较，**如果数组的最大值刚好是在第一位，要将它挪到正确的位置就需要 n - 1 次移动。也就是说，原数组的一个元素如果距离它正确的位置很远的话，则需要与相邻元素交换很多次才能到达正确的位置，这样是相对比较花时间了**。而希尔排序会逐渐减小这个增量的值，随着增量逐渐减小，每组包含的元素越来越多，当增量为1的时候，整个数组被分成一组，算法终止。

![image-20220911112014363](https://pety.oss-cn-shenzhen.aliyuncs.com/img/image-20220911112014363.png)

```Java
/**
 * 希尔排序
 * @param a
 * @return
 */
public static int[] shellSort(int [] a){
    if(a.length == 0)
        return a;
    int len = a.length;
    //增量选择为 len/2，增量可以有多种选择方法
    int gap = len/2;

    while(gap>0){
        //对于每一个增量，进行插入排序
        for(int i=gap;i<len;i++){
            int current = a[i];
            //这里上一个元素的下标为当前下标-gap
            int preindex = i-gap;
            while(preindex>=0 && a[preindex]>current){
                a[preindex+gap] = a[preindex];
                preindex-=gap;
            }
            a[preindex+gap] = current;
        }
        gap/=2;
    }
    return a;
}
```

**由上面代码可以看出，其实希尔排序就是插入排序的优化，代码也很像，只是需要每次对gap进行修改，并且元素之间的间隔不再是固定的1，而是这个gap。**



## 归并排序

> 归并排序是分治法的一个典型应用。将一个大的数组分为多个子序列，对每个子序列进行排序，然后再将已经有序的子序列进行合并，得到最终的有序序列，即：**先让每个子序列有序，再让子序列段间有序。**
>
> - 把长度为n的输入序列分成两个长度为n/2的子序列；
> - 对这两个子序列分别采用归并排序；
> - 将两个排序好的子序列合并成一个最终的排序序列

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/4.gif)

```Java
/**
 * 归并排序
 * @param a
 * @param left
 * @param right
 * @return
 */

public static int [] mergeSort(int [] a,int left,int right){
    if(left < right){
        //将大数组分成两个子数组
        int mid = left+(right-left)/2;
        //对左半边进行排序
        mergeSort(a,left,mid);
        //对右半边进行排序
        mergeSort(a,mid+1,right);
        //合并
        merge(a,left,mid,right);
    }
    return a;
}

public static void merge(int [] a,int left,int mid,int right){
    int [] temp = new int [right-left+1];
    int i = left;
    int j= mid+1;
    int k=0;
    while(i<=mid && j<=right){
        if(a[i] < a[j])
            temp[k++] = a[i++];
        else
            temp[k++] = a[j++];
    }
    while(i<=mid)
        temp[k++] = a[i++];
    while(j<=right)
        temp[k++]= a[j++];
    //将临时数组的元素复制到原数组
    for(i=0;i<k;i++){
        a[left++] = temp[i];
    }
}
```



## 快速排序

>快速排序是选择一个基准数，将大于基准数的元素放在基准数右边，小于基准数的元素放在基准数左边。这是基准数的位置就是有序的了；在分别对左右两个子序列进行同样操作，最后达到有序。
>
>- 从数列中挑出一个元素，称为 “基准”（pivot ）；
>- 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
>- 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/5.gif)

```Java
/**
 * 快速排序
 * @param
 * @param left 数组的左边界
 * @param right 数组的右边界
 * @return
 */
public static void QuickSort(int[] nums, int left, int right){
    if(left < right){
        //找到基准数的有序下表
        int mid = Partition(nums,left,right);
        //将数组分为两部分，递归分区操作
        QuickSort(nums,left,mid-1);
        QuickSort(nums,mid+1,right);
    }
}

public static int Partition(int []nums,int left,int right){
    //默认数组的第一个为基准数
    int pivot = nums[left];
    int i = left+1;
    int j = right;

    while(true){
        //从左到右找到数组中大于基准数的值
        while(i<=j && nums[i] <= pivot)
            i++;
        //从右向左找到数组中小于基准数的值
        while(i<=j && nums[j] >= pivot)
            j--;
        if(i>=j)
            break;
        //交换这两个数，让< 基准数的元素到基准数左边，> 基准数的元素到基准数右边
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    //将基准数放到中间，此时基准数位置有序
    nums[left] = nums[j];
    nums[j] = pivot;
    return j;
}
```



**另外一种快速排序**

```Java
//随机选取基准数
public static void QuickSort(int[] nums, int left, int right){
        if(left < right){
            //随机选取基准数
            int randomIndex = new Random().nextInt(right-left)+left+1;
            //将基准数放在数组的首部
            swap(nums,left,randomIndex);
            int mid = Partition(nums,left,right);
            QuickSort(nums,left,mid-1);
            QuickSort(nums,mid+1,right);
        }
    }

public static int Partition(int [] a,int left,int right){
    int pivot = left,index = left+1;
    //此时right是下标值，因此是<=
    for(int i=index;i<=right;i++){
        //将小于基准数的元素放在前面来，index表示不小于基准数的第一个下标
        if(a[i] < a[pivot]){
            swap(a,index,i);
            index++;
        }
    }
    //index由于每次执行+1，所以最后一个小于基准数的是index-1
    swap(a,index-1,pivot);
    return index-1;
}

//交换两个元素
public static void swap(int [] a,int left,int right){
    int temp = a[left];
    a[left] = a[right];
    a[right] = temp;
}
```

**在选择基准数的时候，如果每次选取的都是当前子序列中的最小值或者最大值，那么经过一次遍历之后，其他元素的位置没有变化。那么就有点像选择排序，时间复杂度为O(n²)。当数组已经有序时，如果选择的不是随机基准数会出现这种情况。**



## 堆排序

> 堆排序是利用堆这种数据结构，构建一个大顶堆，将大顶堆的堆顶元素与堆的最后一个值进行交换，并重新构建大顶堆。由大顶堆堆顶是最大值，因此交换之后数组的最后一个值为最大值，此时有序。
>
> **大顶堆性质：子节点的值一定小于父节点的值。**
>
> **在数组中，2\*index+1是左节点，2\*index+2是左节点**

![](https://pety.oss-cn-shenzhen.aliyuncs.com/img/7.gif)



```java
/**
 * 堆排序
 * @param nums
 */
public static void heapSort(int [] nums){
    int len = nums.length;
    //构架大顶堆
    buildMaxHeap(nums,len-1);

    for(int i = len-1;i>=1;i--){
        //将堆顶放到数组末尾，因为堆顶是最大值，经过这次，最大值有序
        int temp = nums[i];
        nums[i] = nums[0];
        nums[0] = temp;
        //通过下沉重新构建大顶堆
        adjustHeap(nums,0,i-1);
    }
}

/**
 * 构建大顶堆
 * @param nums
 */
public static void buildMaxHeap(int [] nums,int length){
    //根据大顶堆的特性，一个字节的值大于等于其子节点的值
    //所以需要调节每一个有子节点的节点和它的子节点的关系。
    //因此从(length-1)/2开始，这是最后一个非叶子节点
    for(int i=(length-1)/2;i>=0;i--){
        //对非叶子节点通过下沉来构架大顶堆,
        adjustHeap(nums,i,length);
    }
}

/**
 * 下沉操作
 * @param nums
 * @param parent
 * @param n
 */
public static void adjustHeap(int []nums,int parent,int n){
    //记录当前值
    int temp = nums[parent];
    //左孩子
    int child = 2*parent+1;

    while(child <=n){
        //需要将子节点中较大值和父节点进行比较
        //经过这个if，child是子节点中的较大值
        if(child+1<=n&&nums[child] < nums[child+1])
            child++;
        if(nums[child] <=temp)
            break;
        //将子节点上浮到父节点位置，父节点下沉到子节点位置
        nums[parent] = nums[child];
        parent = child;
        child = 2*parent+1;
    }
    nums[parent] = temp;
}
```