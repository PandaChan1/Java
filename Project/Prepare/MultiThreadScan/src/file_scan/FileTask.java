package file_scan;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class FileTask implements Runnable{

    private final ExecutorService threadPool;
    private final File root;
    private final AtomicInteger ai;

    FileTask(File root, ExecutorService threadPool,AtomicInteger ai) {
        this.root = root;
        this.threadPool = threadPool;
        this.ai = ai;
    }
    @Override
    public void run() {
        ai.getAndIncrement();

        File[] files = root.listFiles();
        if (files != null) {
            for (File file :
                    files) {
                if (file.isDirectory()) {
                    FileTask task = new FileTask(file,threadPool,ai);
                    threadPool.execute(task);
                }
            }
        }


        if (ai.decrementAndGet() == 0) {
            //已经是最后一个任务了
        }
    }
}
