/**
 * 认识Callable，对Runnable进行了扩展
 * 对Callable的调用，可以有返回值
 */
package yxxy.c_026;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 带返回值线程
 */
public class T03_Callable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        T03_Callable callable = new T03_Callable();

        FutureTask<String> task = new FutureTask<>(callable);
        Thread t = new Thread(task);
        t.start();

        System.out.println(task.get());
    }
}
