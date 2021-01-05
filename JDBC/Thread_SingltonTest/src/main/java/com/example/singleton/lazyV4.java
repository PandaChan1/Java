package com.example.singleton;

//二次判断提高性能
public class lazyV4 {
    private volatile static lazyV4 instance = null;
    //volatile的目的：
    //保护instance = new lazyV4();
    //不至于出现，其它线程看到instance != null ，但执行的是一个没有被初始化完毕的对象
    public static lazyV4 getInstance() {

        if (instance == null) {

            synchronized (lazyV4.class){

                if (instance == null) {
                    instance = new lazyV4();   //这句可能会重排序
                }
            }
        }
        return instance;
    }
}
