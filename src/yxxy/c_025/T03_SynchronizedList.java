package yxxy.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        //给list加锁
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
