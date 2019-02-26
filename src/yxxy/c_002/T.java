/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */

package yxxy.c_002;

public class T {

    private int count = 10;

    public void m() {
        //任何线程要执行下面的代码，必须先拿到this的锁
        synchronized(this) {
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

