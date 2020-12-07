package day12_7;

import java.util.Scanner;

public class AddLongInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(AddLongInteger1(str1,str2));

    }



    public static String AddLongInteger1(String str1,String str2) {

        if (str1 == null || str1.length() == 0) {
            return str2;
        }

        if (str2 == null || str2.length() == 0) {
            return str1;
        }


        int carry = 0;  //进位

        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(str1.length(),str2.length());
        int i = str1.length();
        int j = str2.length();


        while(sb.length() < maxLen) {
            i--;
            j--;
            int s1;
            int s2;

            if (i >= 0) {
                s1 = str1.charAt(i) - '0';
            }else {
                s1 = 0;
            }

            if (j >= 0) {
                s2  = str2.charAt(j) - '0';
            }else{
                s2 = 0;
            }


            int temp = s1 + s2 + carry;

            if ( temp / 10 == 0) {
                sb.append(temp);
                carry = 0;
            }else {
                sb.append(temp % 10);
                carry = temp / 10;
            }

        }
        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

    public static String addStr(String str1,String str2) {

        if (str1 == null || str1.length() == 0) {
            return str2;
        }
        if (str2 == null || str2.length() == 0) {
            return str1;
        }


        int carry = 0;  //进位

        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(str1.length(),str2.length());
        int i = str1.length();
        int j = str2.length();



        while(sb.length() < maxLen) {
            i--;
            j--;
            int s1;
            int s2;

            if (i >= 0) {
                s1 = str1.charAt(i) - '0';
            }else {
                s1 = 0;
            }

           if (j >= 0) {
              s2  = str2.charAt(j) - '0';
           }else{
               s2 = 0;
           }


           int temp = (s1 + s2 + carry) / 10;

           if ( temp == 0) {
               sb.append((s1 + s2));
           }else {
               sb.append((s1 + s2 + carry) % 10);
               carry = temp;
           }

        }

        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
