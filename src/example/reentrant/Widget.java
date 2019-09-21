package example.reentrant;

/**
 * @author jsjchai.
 */
public class Widget {

    public synchronized void doSomething(){
        System.out.println("widget");
    }
}
