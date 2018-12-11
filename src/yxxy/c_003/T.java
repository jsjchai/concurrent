package yxxy.c_003;

public class T {

    private int count = 10;

    public synchronized void m() { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


    public static void main(String[] args) {
        T t = new T();
        for(int i = 0; i < 10 ; i++){
            new Thread(t::m).start();
        }
    }
}
