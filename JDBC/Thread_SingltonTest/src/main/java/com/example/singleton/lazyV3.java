package com.example.singleton;

//二次判断提高性能
public class lazyV3 {
    private static lazyV3 instance = null;

    public static lazyV3 getInstance() {
        //二次判断，提高性能
        if (instance == null) {  //非空直接返回
            //先判断是否为空，为空则加锁
            synchronized (lazyV3.class){  //加锁,加完之后再判断是否为空
                //能保证instance还是空吗，不能保证
                //因为开始加锁到加上锁之间可能很长时间
                //在这个过程中，也许instance已经不为空了，那么我门需要再次判断
                if (instance == null) {
                    instance = new lazyV3();
                }
            }
        }
        return instance;
    }
}
