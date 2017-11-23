package com.bestway.program.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSingle {
    private static ExecutorService executor;

    private ThreadPoolSingle() {
    }

    public static ExecutorService getInstance() {
        if (executor == null) {
            // 1代表线程池内只能允许一个线程在运行，可以修改
            executor = Executors.newFixedThreadPool(20);
        }
        return executor;
    }
}
