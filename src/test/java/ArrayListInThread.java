import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListInThread implements Runnable{
//    List<String> list1 = new ArrayList<String>();// 效率高，线程不安全
//    List<String> list1 = Collections.synchronizedList(new ArrayList<String>());// 加锁，线程安全
    List<String> list1 = new CopyOnWriteArrayList(); // 适合查询，不适合新增、修改
//    Vector<String> list1 = new Vector<>();  // 效率低，线程安全
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 2));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(Thread.currentThread().getName());
    }
 
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("mygroup");
        ArrayListInThread t = new ArrayListInThread();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("startTime: "+sf.format(new Date()));
        for (int i = 0; i < 10000; i++) {
            Thread th = new Thread(group, t,String.valueOf(i));
            th.start();
        }
        while (group.activeCount() > 0) {
            Thread.sleep(10);
        }
        System.out.println("endTime: "+sf.format(new Date()));
        System.out.println(t.list1.size()); // it should be 10000 if thread safecollection is used.
    }
 
}