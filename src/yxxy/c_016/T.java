/**
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 *
 * @author mashibing
 */
package yxxy.c_016;

import java.util.concurrent.TimeUnit;


public class T {

    int count = 0;

    synchronized void m1() {
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        count++;

        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        //采用细粒度的锁，可以使线程争用时间变短，从而提高效率
        synchronized (this) {
            count++;
        }
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        T t = new T();
        long st = System.nanoTime();
        t.m1();
        long m1Time =  System.nanoTime() - st;
        System.out.println("m1Time="+m1Time);

        long st2 = System.nanoTime();
        t.m2();
        long m2Time =  System.nanoTime() - st2;
        System.out.println("m2Time="+m2Time);
    }


}
