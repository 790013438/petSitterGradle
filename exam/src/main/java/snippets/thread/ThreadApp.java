package snippets.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadApp {

    private static AtomicInteger sum = new AtomicInteger();
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    static class AddThread implements Callable<Integer> {

        private Integer sum = 0;
        private int begin;
        private int end;

        AddThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() {
            for (int i = begin; i <= end; ++i) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Future<Integer> future1 = executorService.submit(new AddThread(1, 10000));
        Future<Integer> future2 = executorService.submit(new AddThread(10001, 20000));
        try {
            Integer integer0 = future1.get();
            Integer integer1 = future2.get();
            System.out.println(integer0 + integer1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
