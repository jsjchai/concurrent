package example.reentrant;

/**
 * @author jsjchai.
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println(Thread.currentThread().getName() + ": calling doSomething");
        super.doSomething();
    }
}
