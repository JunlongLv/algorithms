package cn.lv.algorithms.chapter01;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包
 *  无序集合
 */
public class BagDemo {

    public static void main(String[] args) {
        double[] arr = {1,2,3,4,5,6};
        BagDemo.BagTest(arr);
    }

    public static void BagTest(double[] item){
        Bag<Double> numbers = new Bag<>();
        for (int i = 0; i < item.length; i++) {
            numbers.add(item[i]);
        }
        int N = numbers.size();
        double sum = 0.0;
        for (Double s:numbers) {
            sum += s;
        }
        double mean = sum / N;
        sum = 0.0;
        for (Double x:numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.abs(sum / (N - 1));
        StdOut.printf("Mean: %.2f\n",mean);
        StdOut.printf("Std: %.2f\n",std);
    }
}
