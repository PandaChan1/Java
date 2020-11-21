package EnumDemo;

/**
 *@ClassName: TestEnum
 *@Description 自己写的枚举类，默认继承自enum
 *@Author PandaChan1
 *@Date 2020/11/21
 *@Time 10:37
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、自己写的枚举类，会默认继承Enum
 * 问题：Enum类为什么没有values方法
 * 2、枚举类方法默认是private的
 * 通过反射获取枚举类的类对象需要多个参数，因为我们写的枚举类默认继承自Enum
 * 而观察Enum的源码，发现Enum只提供了一个两个参数的构造方法。
 * 而子类的构造方法在实现时，会自动先构造父类（ super关键字 ）。Enum父类需要两个参数，因此需要多传入两个参数
 */

public enum TestEnum {
    RED,BLACK,GREEN,WHITE;
    public static void main(String[] args) {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit.".toLowerCase().trim();
        String[] split = str.split("[ .,':?!]");
        System.out.println(Arrays.toString(split));

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].trim().equals("")) {
                continue;
            }
            map.put(split[i].trim(),map.getOrDefault(split[i].trim(),0) + 1);
        }
        for (Map.Entry<String, Integer> entry:
        map.entrySet()){
            System.out.println(entry.getKey() + "" + entry.getValue());
        }
        }
    }

