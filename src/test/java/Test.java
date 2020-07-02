import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    @org.junit.jupiter.api.Test
    public void listTest(){
        List<String> list = new ArrayList<>();
        list.add("ljl");
        list.add("py");
        list.add("leo");

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    public void linkedListTest(){
        List linkedList = new LinkedList();
        linkedList.add("ljl");
        linkedList.add("py");
        linkedList.add("leo");

        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }

        linkedList.remove("leo");
    }

    public static void main(String[] args) throws InterruptedException {
        final List<Integer> list = new ArrayList<Integer>();

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000 ; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
