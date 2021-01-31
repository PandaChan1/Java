package day1_31;

import java.util.Scanner;

/**
 *@ClassName: Decode
 *@Description 字符串加解密
 *@Author PandaChan1
 *@Date 2021/1/31
 *@Time 17:55
 */

/**
 *  1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 */

//思路：if-else即可，熟悉ascii
public class Decode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            encrypt(s1);
            unEncrypt(s2);
        }
    }
    public static void encrypt(String s){
        StringBuffer str = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)>=97){
                str.append((char)((s.charAt(i)-97+1) %26+65));
            }else if(s.charAt(i)>=65){
                str.append((char)((s.charAt(i)-65+1) %26+97));
            } else{
                str.append((char)((s.charAt(i)-48+1) %10+48));
            }
        }
        System.out.println(str);
    }
    public static void unEncrypt(String s){
        StringBuffer str = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)>=97){
                if(s.charAt(i)=='a'){
                    str.append('Z');
                }else{
                    str.append((char)((s.charAt(i)-97-1) %26+65));
                }
            } else if(s.charAt(i)>=65){
                if(s.charAt(i)=='A'){
                    str.append('z');
                }else{
                    str.append((char)((s.charAt(i)-65-1) %26+97));
                }
            }else{
                if(s.charAt(i) == '0'){
                    str.append('9');
                }else{
                    str.append((char)((s.charAt(i)-48-1) %10+48));
                }
            }
        }
        System.out.println(str);
    }
}
