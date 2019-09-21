package example.reentrant;

/**
 * @author jsjchai.
 */
public class Example27 {

    public static void main(String[] args) {
        LoggingWidget widget = new LoggingWidget();

        Thread t1 = new Thread(widget::doSomething);
        Thread t2 = new Thread(widget::doSomething);

        t1.start();
        t2.start();
    }
}
