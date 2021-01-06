package day1_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();

        Arrays.sort(gifts);
        for (int i = 0; i < n; i++) {
            int key = gifts[i];
            map.put(key,map.getOrDefault(key,0) + 1);
        }
        for (Map.Entry<Integer, Integer> m :map.entrySet()) {
            if (m.getValue() > n/2) {
                return m.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        gift g = new gift();
        System.out.println(g.getValue(new int[]{1, 2, 3, 2, 2}, 5));
    }
}
