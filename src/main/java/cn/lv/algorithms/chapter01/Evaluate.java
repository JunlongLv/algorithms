package cn.lv.algorithms.chapter01;

import java.util.Stack;

/**
 * Dijkstra的双栈算术表达式求值算法
 */
public class Evaluate {

    public static void main(String[] args) {
        double a = Evaluate.test("( 1 + ( 2 * 3 ) )");
        System.out.println(a);
    }

    public static double test(String s){
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String[] arr = s.split(" ");
        for (String i : arr) {
            // 操作符压入栈
            if(i.equals("("));
            else if(i.equals("+")) ops.push(i);
            else if(i.equals("-")) ops.push(i);
            else if(i.equals("*")) ops.push(i);
            else if(i.equals("/")) ops.push(i);
            else if(i.equals("sqrt")) ops.push(i);
            else if(i.equals(")")) {
                // 如果字符为 ')' 弹出操作符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")) v = vals.pop() + v;
                else if(op.equals("-")) v = vals.pop() - v;
                else if(op.equals("*")) v = vals.pop() * v;
                else if(op.equals("/")) v = vals.pop() / v;
                else if(op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }else {
                // 如果字符既非运算符也不是括号，将它作为double值压入栈
                vals.push(Double.parseDouble(i));
            }
        }
        return vals.pop();
    }
}
