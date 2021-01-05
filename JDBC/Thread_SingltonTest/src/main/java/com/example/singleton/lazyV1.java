package com.example.singleton;

//懒汉模式
//不是线程安全的
public class lazyV1 {
    private  static lazyV1 instance = null;


    public static lazyV1 getInstance() {
        //有人要用该对象时
        if (instance == null) {
            //用到时再实例化
            instance = new lazyV1();
        }
        return instance;
    }
}
