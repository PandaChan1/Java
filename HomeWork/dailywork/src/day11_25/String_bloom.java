package day11_25;

import java.util.HashSet;
import java.util.Set;

public class String_bloom {
    public static void main(String[] args) {
        System.out.println(filtter("they are students.", "aeiou"));
    }

    public static String filtter(String str1,String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            set.add(str2.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (!set.contains(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }
}
