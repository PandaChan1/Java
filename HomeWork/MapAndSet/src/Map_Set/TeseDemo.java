package Map_Set;

import java.util.*;

public class TeseDemo {

    public static void findfirstVal() {  //10w数据找到第一个重复的
        long random  = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            int ran = (int) (random % (100000 - 1) + 1);
            if (!set.contains(ran)) {
                set.add(ran);
            }else {
                System.out.println(ran);
                return;
            }
        }
    }

    public static void distinct() {  //10w数据去重
        long random  = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            int ran = (int) (random % (100000 - 1) + 1);
            set.add(ran);
        }
    }

    public static void count() {  //统计重复出现数字的次数
        long random  = System.currentTimeMillis();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            //随机数的三种写法
            /**
             * 1、long random  = System.currentTimeMillis();   int ran = (int) (random % (100000 - 1) + 1);  //闭区间
             * 2、 int ran = (int)(Math.random() * (100 - 1) + 1);  //闭区间
             * 3、Random  random = new Random();  int ran = random.nextInt(100)  // <100  左闭右开
             */
            int ran = (int) (random % (100000 - 1) + 1);
            if (map.containsKey(ran)){
                Integer val = map.get(ran);
                map.put(ran,val++);
            }else {
                map.put(ran,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();  //不能存放重复的数据
        set.add("abcd");
        set.add("abcdef");
        set.add("abcd");
        System.out.println(set);

        Iterator<String> it = set.iterator();  //迭代器,实现了Iterable接口的类都可以使用迭代器
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        findfirstVal();
        distinct();
        count();
    }
    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();  //不能使用iterator,但是可以使用Entry
        map.put("及时雨","宋江");
        System.out.println(map.get("及时雨"));

        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
