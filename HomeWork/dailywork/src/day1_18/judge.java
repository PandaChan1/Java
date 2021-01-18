package day1_18;

import java.util.Scanner;

/**
 *@ClassName: judge
 *@Description 奇偶校验
 *@Author PandaChan1
 *@Date 2021/1/18
 *@Time 15:24
 */


public class judge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();  //读出一个字符串
            helper(str);
        }
    }

    //对字符串中每个字符进行奇校验
    private static void helper(String str) {
        char[] chars = str.toCharArray();
        for (char c :
                chars) {
            String s = Integer.toBinaryString(c);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            char[] tmp = s.toCharArray();

            if (count % 2 == 0) {
               if (tmp.length < 8) {
                   StringBuilder prefix = new StringBuilder();
                   prefix.append(1);
                   for (int i = 0; i < (8 - tmp.length) - 1; i++) {
                       prefix.append(0);
                   }
                   System.out.println(prefix.append(new String(tmp)).toString());
               }else {
                   tmp[0] = 1;
                   System.out.println(new String(tmp));
                }
            }else {
                if (tmp.length < 8) {
                    StringBuilder prefix = new StringBuilder();
                    for (int i = 0; i < (8 - tmp.length); i++) {
                        prefix.append(0);
                    }
                    System.out.println(prefix.append(new String(tmp)).toString());
                }else {
                    System.out.println(s);
                }
            }
        }
    }
}
