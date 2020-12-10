package day12_10;

import java.util.*;

public class grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lists = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        while(sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(sc.next());
                map.put(tmp,map.getOrDefault(tmp,0) + 1);
            }

            int target = sc.nextInt();

            lists.add(map.getOrDefault(target, 0));

        }

        for (int i :
                lists) {
            System.out.println(i);
        }
    }
}
