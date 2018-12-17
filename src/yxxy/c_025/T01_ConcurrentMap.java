/**
 * http://blog.csdn.net/sunxianghuang/article/details/52221913
 * http://www.educity.cn/java/498061.html
 * 阅读concurrentskiplistmap
 */
package yxxy.c_025;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {
    public static void main(String[] args) {

        System.out.print("ConcurrentHashMap:");
        put(new ConcurrentHashMap<>());
        System.out.print("ConcurrentSkipListMap:");
        //高并发并且排序
        put(new ConcurrentSkipListMap<>());
        System.out.print("Hashtable:");
        put(new Hashtable<>());

//        System.out.print("TreeMap:");
//        put(new TreeMap<>());

        System.out.print("HashMap:");
        //Collections.synchronizedList()
        put(new HashMap<>());



    }

    private static void put(Map<String, String> map){
        long start = System.currentTimeMillis();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        Random r = new Random();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t -> t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
