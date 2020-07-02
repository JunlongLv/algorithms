package cn.lv.algorithms.chapter01;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包 （链表实现）
 */
public class Bag_lv<Item> implements Iterable<Item> {

    private Node first;     // 链表的首节点
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

    // 放入背包
    private void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {

        }
    }

    // 测试
    public static void main(String[] args) {
        Bag_lv<String> bag = new Bag_lv<>();
        bag.add("leo");
        bag.add("alex");
        bag.add("lv");
        System.out.println(bag.size());
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("Bag中的值："+item);
        }
    }
}
