package cn.lv.algorithms.chapter01;

import java.util.Iterator;

/**
 * 先进先出队列（链表实现）
 */
public class Queue_lv<Item> implements Iterable<Item> {
    private Node first;     // 指向最早添加的节点的链接
    private Node last;      // 指向最近添加的节点的链接
    private int N;          // 队列中的元素数量

    // 内部节点类
    private class Node {
        Item item;
        Node next;
    }

    private boolean isEmpty() {
        return first == null;  // N == 0
    }

    private int size() {
        return N;
    }

    // 入列
    private void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())   first = last;
        else    oldLast.next = last;
        N++;
    }

    // 出列
    private Item dequeue() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = first;
        N--;
        return item;
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
        Queue_lv<Integer> queue = new Queue_lv<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
