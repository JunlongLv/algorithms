package cn.lv.algorithms.chapter01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压堆栈 （链表实现）
 */
public class Stack_lv<Item> implements Iterable<Item> {

    private Node first;     // 栈顶(最近添加的元素)
    private int N;          // 栈元素数量

    // 定义节点内部类
    private class Node {
        Item item;
        Node next;
    }

    private boolean isEmpty(){
        return first == null; // N == 0
    }

    private int size(){
        return N;
    }

    // 压入栈
    private void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    // 弹出栈
    private Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    // 返回栈中最近添加的元素
    private Item peek() {
        if(isEmpty()) throw new NoSuchElementException("元素为空");
        return first.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    // 测试
    public static void main(String[] args) {
        Stack_lv<String> stack_lv = new Stack_lv<>();
        stack_lv.push("leo");
        stack_lv.push("alex");
        stack_lv.push("lv");
        System.out.println(stack_lv.size());
        String a1 = stack_lv.pop();
        String a2 = stack_lv.pop();
        String a3 = stack_lv.peek();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println("peek:" + a3);
    }
}
