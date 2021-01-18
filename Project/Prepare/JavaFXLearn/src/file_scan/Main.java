package file_scan;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 *@ClassName: Main
 *@Description 文件搜索
 *@Author PandaChan1
 *@Date 2021/1/18
 *@Time 11:06
 */


public class Main {
    public static void main(String[] args) {
        File root = new File("E:\\博客\\Android");  //传入根路径


        //项目中使用哪一种方式都可以
//        traverDepth(root);
//        traverBread(root);
    }

    //广度优先--队列
    public static void traverBread(File root) {

        Queue<File> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            File f = queue.poll();
            if (f.isDirectory()){
                File[] files = f.listFiles();
                if (files != null && files.length != 0) {
                    for (File w :
                            files) {
                        queue.offer(w);
                    }
                }
                System.out.println(f);
            }else {
                System.out.println(f);
            }
        }
    }

    //深度优先--栈---递归
    public static void traverDepth(File root) {
        System.out.println("文件夹：" + root);
        File[] files = root.listFiles();
        if (files == null) {
            return;
        }

        if (files.length == 0) {
            return;
        }
        for (File file: files) {
            if (!file.isDirectory()) {
                System.out.println("普通文件：" + file);
                continue;
            }
                traverDepth(file);
        }
    }



}
