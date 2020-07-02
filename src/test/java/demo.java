public class demo {
    public static void main(String[] args) throws InterruptedException {
        testRun(100000000L);
    }

    private static void testRun(long num) throws InterruptedException {
        long s = num/2;
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < s; i++) {
                    a++;
                }
                System.out.println(a);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < s; i++) {
                    b++;
                }
                System.out.println(b);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("耗时： "+time+"ms");
    }
}
