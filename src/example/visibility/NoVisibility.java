package example.visibility;

import java.util.concurrent.TimeUnit;

/**
 * @author jsjchai.
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 333;
        ready = true;

    }


}
