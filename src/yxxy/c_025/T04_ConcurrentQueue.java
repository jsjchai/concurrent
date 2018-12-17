package yxxy.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        /**
         * 无界队列
         */
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("a" + i);  //add
        }

        System.out.println(strs);

        System.out.println(strs.size());

        //head 出队列
        System.out.println(strs.poll());
        System.out.println(strs.size());

        //拿一个值出来,不出队列
        System.out.println(strs.peek());
        System.out.println(strs.size());

        //双端队列Deque
    }
}
