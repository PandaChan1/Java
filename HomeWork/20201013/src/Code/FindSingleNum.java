package Code;

import Data.GroupOfNumber;

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName: FindSingleNum
 *@Description 一组数据中出现次数为一次的数据
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 19:48
 */


public class FindSingleNum {
    public static void main(String[] args) {
        find(GroupOfNumber.GROUP_NUMBER);
    }

    //优化
    //数据中只有一个数据出现一次
    //^ 异或，相同的数异或为0，0异或任意数为任意数
    private static int findNum(int[] num) {
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            res = res ^ num[i];
        }
        return res;
    }


    //数据中多个数据只出现一次
    //暴力解法
    public static void find(int[] number) {
        for (int i = 0;i < number.length; i++) {
            int count=0;
            for (int j = 0;j < number.length; j++) {
                if (number[i] == number[j]) {
                    count++;
                }
                }
                   if(count == 1) {
                       System.out.println("出现次数为一次的数据是 "+number[i]);
                   }
        }
    }


    //数据中多个数据只出现一次
    //map存储
    public static void FindNum(int[] number) {
        Map<Integer,Integer> map = new HashMap<>();
        if (number.length == 0 ) {
            System.out.println("请输入正确的数据");
        }
        for (int i :
                number) {
            if (!map.containsKey(i)) {
                map.put(i,1);
            } else {
                map.put(i,2);
            }
        }
        int res = 0;
        for (int m :
                map.keySet()) {
            Integer val = map.get(m);
            if (val == 1) {
                res = m;
            }
            System.out.println("出现次数为一次的数据是 "+res);
        }
    }
}
