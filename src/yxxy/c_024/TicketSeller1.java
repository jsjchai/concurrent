/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * 重复销售？超量销售？
 *
 * @author 马士兵
 */
package yxxy.c_024;

import java.util.ArrayList;
import java.util.List;

public class TicketSeller1 {
   private static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) tickets.add("票编号：" + i);
    }

    /**
     * 原子性
     * 并发情况会导致ArrayIndexOutOfBoundsException
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }
}