package com.example.singleton;

//饿汉模式
//线程安全+安全
//构造的早，如果不用就浪费空间了
public class Hungry {
    private Hungry() {}  //私有构造方法，外部不能new我的对象
    private static Hungry instance = new Hungry();  //只会有一个对象，由我本身创建

    public  static Hungry getInstance() {
        return instance;
    }

}
