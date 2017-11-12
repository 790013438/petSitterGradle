package snippets.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

    private static AtomicInteger sum = new AtomicInteger();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    static class AddThread implements Callable<AtomicInteger> {

        private AtomicInteger sum = new AtomicInteger(0);
        private int begin;
        private int end;

        AddThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public AtomicInteger call() {
            for (int i = begin; i <= end; ++i) {
                sum.addAndGet(i);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Future<AtomicInteger> future1 = executorService.submit(new AddThread(1, 10000));
        Future<AtomicInteger> future2 = executorService.submit(new AddThread(10001, 20000));
        try {
            AtomicInteger atomicInteger0 = future1.get();
            AtomicInteger atomicInteger1 = future2.get();
            System.out.println(atomicInteger0.addAndGet(atomicInteger1.intValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
