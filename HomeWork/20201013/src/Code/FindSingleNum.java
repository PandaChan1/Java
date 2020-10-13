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
        System.out.println("出现次数为一次的数据为"+find(GroupOfNumber.GROUP_NUMBER));
    }


    public static int find(int[] number) {
        for (int i = 0;i < number.length; i++) {
            int count=0;
            for (int j = 0;j < number.length; j++) {
                if (number[i] == number[j]) {
                    count++;
                }
                }
                   if(count == 1) {
                        return number[i];
                   }
        }
        return 0;
    }
    public static int FindNum(int[] number) {
        Map<Integer,Integer> map = new HashMap<>();
        if (number.length == 0 ) {
            System.out.println("请输入正确的数据");
            return 0;
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
        }
        return res;
    }
}
