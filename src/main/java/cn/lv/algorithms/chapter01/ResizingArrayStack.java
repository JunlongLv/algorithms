package cn.lv.algorithms.chapter01;

import java.util.Iterator;

/**
 * 下压栈
 *   遍历时能够动态调整数组大小的实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    Item[] arr = (Item[]) new Object[1];    // 存储栈元素
    int N = 0;                              // 栈元素数量

    private boolean isEmpty() {
        return N == 0;
    }

    private int size() {
        return N;
    }

    // 压入栈
    private void push(Item item) {
        if(N == arr.length) resize(2 * arr.length);
        arr[N++] = item;
    }

    // 弹出栈
    private Item pop() {
        Item item = arr[--N];
        arr[N] = null;  // 避免对象游离
        if(N > 0 && N == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    // 改变栈容量
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = arr[i];
        arr = temp;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        private int i = N;

        public boolean hasNext(){
            return i > 0;
        }

        public Item next(){
            return arr[--i];
        }

        public void remove(){}
    }

    // 测试
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        stack.push("leo");
        stack.push("alex");
        stack.push("lv");
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
    }

}
