package yxxy.c_004;

public class T {

    private static int count = 10;

    /**
     * 这里等同于synchronized(yxxy.c_004.T.class)
     */
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    /**
     * 考虑一下这里写synchronized(this)是否可以？
     * 不可以，静态方法不需要new，没有this
     */
    public static void mm() {
        synchronized(T.class) {
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i < 10 ; i++){
            //new Thread(T::m).start();

            new Thread(T::mm).start();
        }
    }
}
