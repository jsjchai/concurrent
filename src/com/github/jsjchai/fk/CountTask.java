package com.github.jsjchai.fk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 *  fork join实现1+2+...+100
 */
public class CountTask extends RecursiveTask<Long> {

    private Integer start;

    private Integer end;

    /**
     * 阈值
     */
    private static final int THRESHOLD = 10;

    public CountTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {


        boolean canCompute = (end - start) <= THRESHOLD;

        // 求和
        long sum = 0;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            System.out.println(start+"--"+middle);
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            leftTask.fork();
            rightTask.fork();

            sum = leftTask.join() + rightTask.join();
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        CountTask task = new CountTask(1, 100);

        Future<Long> future = pool.submit(task);
        System.out.println(future.get());
    }
}
