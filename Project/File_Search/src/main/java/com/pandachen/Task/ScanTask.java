package com.pandachen.Task;

import com.pandachen.Model.FileMeta;
import com.pandachen.Service.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class ScanTask implements Runnable{
    private final File directory;
    private final ExecutorService threadPool;
    private final AtomicInteger counter;
    private final CountDownLatch doneSignal;
    private final FileService fileService = new FileService();

    public ScanTask(File directory, ExecutorService threadPool, AtomicInteger counter, CountDownLatch doneSignal) {
        this.directory = directory;
        this.threadPool = threadPool;
        this.counter = counter;
        this.doneSignal = doneSignal;
    }
    @Override
    public void run() {
        File[] files = directory.listFiles();
        List<FileMeta> res = new ArrayList<>();
        if (files != null) {
            for (File file :
                    files) {
                if (file.isDirectory()) {
                    ScanTask task = new ScanTask(file,threadPool,counter,doneSignal);
                    //计数
                    counter.incrementAndGet();
                    //提交给线程池
                    threadPool.execute(task);
                }else {
                    //不是文件夹,要保存起来
                    res.add(new FileMeta(file));
                }
            }
        }


        //公用一个线程池，直接给线程池加锁，变成串行
        synchronized (threadPool) {
            fileService.differ(directory.getAbsolutePath(),res);
        }


        if (counter.decrementAndGet() == 0) {
            //做完最后一个任务
            doneSignal.countDown();  //发送结束信号
        }
    }
}
