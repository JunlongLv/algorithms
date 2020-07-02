package cn.lv.algorithms.chapter01;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Select {
    public static void sort(Comparable[] arr){
        for (int i = 0; i <= arr.length - 2; i++) {
            // 记录最小元素所在的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(greater(arr[minIndex],arr[j])){
                    minIndex = j;
                }
            }
            // 交换位置
            exch(arr,i,minIndex);
        }
    }

    private static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    private static void exch(Comparable[] arr,int a,int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6,5,4,3,2,1};
        Select.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
