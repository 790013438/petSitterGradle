package snippets.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

    private static AtomicInteger sum = new AtomicInteger();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

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
                sum.addAndGet(i);
            }
        }
    }

    public static void main(String[] args) {
        executorService.execute(new AddThread(1, 10000));
        executorService.execute(new AddThread(10001, 20000));
        executorService.shutdown();
        while(!executorService.isTerminated()){}
        System.out.println(sum);
    }
}
