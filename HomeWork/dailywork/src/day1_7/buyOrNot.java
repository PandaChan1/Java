package day1_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class buyOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();


            Map<Character,Integer> want = new HashMap<>();
            for (int i = 0; i < s2.length(); i++) {
                char c = s2.charAt(i);
                want.put(c,want.getOrDefault(c,0) + 1);
            }

            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (want.containsKey(c) && want.get(c) > 0) {
                    want.put(c,want.get(c) - 1);
                }
            }
            int res = 0;
            for (Integer i :
                    want.values()) {
                res += i;
            }

            if (res == 0) {
                int i = s1.length() - s2.length();
                System.out.println("Yes " + i);
            }else {
                System.out.println("No " + res);
            }
        }
    }
}
