package snippets;

public class App {

    //atom
    private static int sum;

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddThread(1, 10000));
        t1.start();
        Thread t2 = new Thread(new AddThread(10001, 20000));
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    static class AddThread extends Thread {
        private int begin;
        private int end;

        AddThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = begin; i <= end; ++i) {
                sum += 1;
            }
        }
    }
}
