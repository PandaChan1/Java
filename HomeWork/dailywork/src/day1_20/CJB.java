package day1_20;

import java.util.*;

public class CJB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> p1Map = new TreeMap<String, Integer>();
        TreeMap<String, Integer> p2Map = new TreeMap<String, Integer>();
        while(sc.hasNext()) {
            int n = sc.nextInt();  //读取总共的比赛次数
            int player1 = 0;
            int player2 = 0;
            int mid = 0;
            for (int i = 0; i < n; i++) {
                String p1 = sc.next();
                String p2 = sc.next();
                if (p1.compareTo(p2) < 0) {
                    if ("B".equals(p1) && "J".equals(p2)) {
                        p2Map.put(p2,p2Map.getOrDefault(p2,0) + 1);
                        player2++;
                        continue;
                    }
                    p1Map.put(p1,p1Map.getOrDefault(p1,0) + 1);
                    player1++;
                }else if (p1.compareTo(p2) > 0) {
                    if ("J".equals(p1) && "B".equals(p2)) {
                        p1Map.put(p1,p1Map.getOrDefault(p1,0) + 1);
                        player1++;
                        continue;
                    }
                    p2Map.put(p2,p2Map.getOrDefault(p2,0) + 1);
                    player2++;
                }else {
                    mid++;
                }
            }

            ArrayList<Map.Entry<String, Integer>> p1List = new ArrayList<>(p1Map.entrySet());
            ArrayList<Map.Entry<String, Integer>> p2List = new ArrayList<>(p2Map.entrySet());
            Collections.sort(p1List,((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
            Collections.sort(p2List,((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

            System.out.println(player1 + " "+ mid + " " + (n - player1 - mid));
            System.out.println(player2 + " "+ mid + " " + (n - player2 - mid));

            for (Map.Entry<String, Integer> entry:
            p1List){
                System.out.print(entry.getKey() + " ");
                break;
            }

            for (Map.Entry<String, Integer> entry :
                    p2List) {
                System.out.println(entry.getKey());
                break;
            }

        }
    }
}

