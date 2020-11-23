package day11_22;

import java.util.Scanner;

/**
 *@ClassName: BuildCycleString
 *@Description 将B字符串插入A中，是否可以构成回文字符串，有几种方法
 *@Author PandaChan1
 *@Date 2020/11/23
 *@Time 15:09
 */


public class BuildCycleString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();
        int ans = 0;


        int len = 0;

        while(len < str1.length() + 1) {
            StringBuilder sb = new StringBuilder(str2);
            StringBuilder temp;
            String tmp;
            if (len == 0) {
                temp= sb.append(str1);
                tmp = temp.toString();
                if (isEquals(temp.reverse().toString(),tmp)) {
                    ans++;
                }
                len++;
                continue;
            }

            StringBuilder subHead = new StringBuilder(str1.substring(0,len));
            sb = sb.append(str1.substring(len));
            temp = subHead.append(sb);
            tmp = temp.toString();
            if (isEquals(temp.reverse().toString(),tmp)) {
                ans++;
            }
            len++;
        }


        System.out.println(ans);
    }
    private static boolean isEquals(String s1,String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
