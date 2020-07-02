package cn.lv.algorithms.chapter01;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(greater(arr[j-1],arr[j])){
                    exch(arr,j-1,j);
                }else {
                    break;
                }
            }
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
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
