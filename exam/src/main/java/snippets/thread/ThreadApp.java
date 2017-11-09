package snippets.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

    private static AtomicInteger sum = new AtomicInteger();

    static class AddThread implements Runnable {

        private int begin;
        private int end;

        public AddThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = begin; i <= end; ++i) {
                sum.getAndAdd(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddThread(1, 10000));
        t1.start();
        Thread t2 = new Thread(new AddThread(10000, 20000));
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
