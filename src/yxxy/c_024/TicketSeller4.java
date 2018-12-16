/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 * <p>
 * 使用Vector或者Collections.synchronizedXXX
 * 分析一下，这样能解决问题吗？
 * <p>
 * 就算操作A和B都是同步的，但A和B组成的复合操作也未必是同步的，仍然需要自己进行同步
 * 就像这个程序，判断size和进行remove必须是一整个的原子操作
 * <p>
 * 使用ConcurrentQueue提高并发性
 *
 * @author 马士兵
 */
package yxxy.c_024;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class TicketSeller4 {
    private static Queue<String> tickets = new ConcurrentLinkedQueue<>();


    static {
        for (int i = 0; i < 100; i++) tickets.add("票 编号：" + i);
    }


    public static void main(String[] args) {

        long st = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                while (true) {
                    //tickets.size() 要遍历一遍集合的

                    String s = tickets.poll();
                    if(s == null){
                        //System.out.println("end");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" "+"销售了--" + s+" "+tickets.size()+" "+tickets.isEmpty());
                }
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("times:" + (System.currentTimeMillis()-st)+" "+latch.getCount());
    }
}
