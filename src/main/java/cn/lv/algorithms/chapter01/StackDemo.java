package cn.lv.algorithms.chapter01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 下压栈
 */
public class StackDemo {
    public static void main(String[] args) {
        double[] arr = {1,2,3,4,5,6};
        StackDemo.stackTest(arr);
    }

    public static void stackTest(double[] arr){
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (double s : stack) {
            StdOut.println(s);
        }
    }


}
