package cn.lv.algorithms.chapter01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubbled {

    public static void sort(Comparable[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(compare(arr[j],arr[j+1])){
                    transposition(arr,j,j+1);
                }
            }
        }
    }

    private static boolean compare(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    private static void transposition(Comparable[] arr,int a,int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6,5,4,3,2,1};
        Bubbled.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
