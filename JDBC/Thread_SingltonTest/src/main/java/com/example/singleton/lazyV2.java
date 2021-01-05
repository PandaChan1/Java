package com.example.singleton;

//线程安全了
//性能不高
public class lazyV2 {
    private static lazyV2 instance = null;

    public static lazyV2 getInstance(){
        //加锁保证线程安全
        synchronized (lazyV2.class) {
            //每次都加锁，加完之后判断是否为空，
            // 但是变量只有一份，只有第一次可能需要加锁，其他时候instance都是非空，这时只需要返回即可
            //而该方式每次先加锁，加完才判断
            if (instance == null) {
            instance = new lazyV2();
            }
        }
        return instance;
    }
}
