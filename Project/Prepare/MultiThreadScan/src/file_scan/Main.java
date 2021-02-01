package file_scan;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\博客");  //路径
        scan(file);

        //
    }

    private static void scan(File file) {
        ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        AtomicInteger ai = new AtomicInteger(0);
        FileTask task = new FileTask(file, threadPool, ai);
        threadPool.execute(task);
    }

}
