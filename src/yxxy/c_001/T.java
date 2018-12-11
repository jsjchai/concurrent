/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

package yxxy.c_001;

public class T {

    private int count = 10;
    private Object o = new Object();

    public void m() {
        //任何线程要执行下面的代码，必须先拿到o的锁
        synchronized(o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i = 0; i < 10 ; i++){

            new Thread(t::m).start();
        }
    }

}

