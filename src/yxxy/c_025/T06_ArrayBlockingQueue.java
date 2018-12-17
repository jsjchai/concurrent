package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 有界队列
 */
public class T06_ArrayBlockingQueue {

    private static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        //满了就会等待，程序阻塞
        //strs.put("aaa");
        //strs.add("aaa");
        //添加值到队列，并返回保存结果
        boolean suc = strs.offer("aaa");
        System.out.println(suc);
        //strs.offer("aaa", 1, TimeUnit.SECONDS);

        System.out.println(strs);
    }
}
