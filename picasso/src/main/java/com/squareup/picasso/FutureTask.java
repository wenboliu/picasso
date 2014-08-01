package com.squareup.picasso;

import java.util.concurrent.Callable;

/**
 * Created by twer on 8/1/14.
 */
public class FutureTask<T> extends java.util.concurrent.FutureTask<T> implements Order {
    private Runnable runnable;

    public FutureTask(Callable<T> callable) {
        super(callable);
    }

    public FutureTask(Runnable runnable, T result) {
        super(runnable, result);
        this.runnable = runnable;
    }


    @Override
    public int getPriority() {
        if(runnable instanceof Order) {
            return ((Order)runnable).getPriority();
        }
        return 0;
    }
}
