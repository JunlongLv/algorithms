package cn.lv.algorithms.chapter01;

import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;

/**
 * 队列
 *  先进先出
 */
public class QueueDemo {

    public static void main(String[] args) {
        double[] arr = {1,2,3,4,5,6};
        double[] a = QueueDemo.queueTest(arr);
        System.out.println(Arrays.toString(a));
    }

    public static double[] queueTest(double[] arr){
        Queue<Double> queue = new Queue<Double>();
        for (int i = 0; i < arr.length; i++) {
            queue.enqueue(arr[i]);
        }
        int N = queue.size();
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = queue.dequeue();
        }
        return a;
    }
}
