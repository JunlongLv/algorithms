package cn.lv.algorithms.chapter01;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {9,2,10,4,5};
        Arrays.sort(arr);
        System.out.println(BinarySearch.rank(2,arr));
    }

    private static int rank(int key,int[] a){
        // 数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 被查找的值要么不存在，要么必然存在于a[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
