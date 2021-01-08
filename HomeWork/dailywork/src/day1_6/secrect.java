package day1_6;

import java.util.Scanner;

public class secrect {
   static char chars[] = new char[]{
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            String res = helper(s);
            System.out.println(res);
        }
    }

    public static String helper(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                int index = c - 5 - 'A';
                if (index <= 0){
                    index += 26;
                }
                sb.append(chars[index]);
            }else {
                sb.appendCodePoint(c);
            }
        }
        return sb.toString();
    }
}
