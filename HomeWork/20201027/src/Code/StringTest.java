package Code;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
    public static void test(){
        System.out.println("test");
    }
    public static void main(String[] args) {
        ((StringTest)null).test();
    }
    public static String merge(String str1,String str2) {
        String str = str1 + str2;
        return str;
    }
    public static void main6(String[] args) {
    /*    String str ="wangchenyangliangwwwmmaan";
        System.out.println(str.replace("an", "xx"));  //字符串替换，替换所有的an
        String str1 = "hello wang li o";
        String[] s = str1.split(" ");
        String[] s1 = str1.split(" ",2);  //最多分割成两部分
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(s1));
        */
    /*    String str = "hello.wang.li,oo,pre";
        String[] split = str.split("\\.");
        for (String s :
                split) {
            System.out.println(s);
        }*/
 /*       String str = "hello\\world\\morning";
        String[] split = str.split("\\\\");
        for (String s :
                split) {
            System.out.println(s);
        }*/
        String str = "name=zhang&age=18";
        String[] split = str.split("&");
        for (String s :
                split) {
            String[] split1 = s.split("=");
            for (String s2:
            split1) {
                System.out.println(s2);
            }
        }

    }
    public static void main5(String[] args) {
        String str ="chenwanglizhaowaliwang";
        System.out.println(str.indexOf("an"));  //字符串第一次出现的下标，a的下标
        System.out.println(str.indexOf("an", 7));  //从7号开始找
        System.out.println(str.lastIndexOf("an", 6)); //
        System.out.println(str.startsWith("z"));  //以...开头
        System.out.println(str.endsWith("o"));  //以...结尾
    }
    public static void main4(String[] args) {
       /* String str = "abcde";
        String str2 = "aabbccdd";
        System.out.println(str.compareTo(str2));*/
        String str = "abcseedefh";
        System.out.println(str.contains("see"));
    }
    public static boolean isNumberChar(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
    public static void main3(String[] args) throws UnsupportedEncodingException {
//        String str = "123456";
//        System.out.println(isNumberChar(str));
       /* byte[] bytes = {97,98,99,100}; //a,b,c,d
        System.out.println(new String(bytes));*/
   /*     String str = "abcd";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));*/
        String str = "hello";
        String str2 = "HeLLo";
        System.out.println(str.equalsIgnoreCase(str2));  //忽略大小写比较字符串

    }
    public static void main2(String[] args) {
        char[] array = {'a', 'b', 'c'};
        String str = new String(array, 0, 3);
        System.out.println(str);

        String str2 = "abcdefghijklmnopqrstuvwxyz";
        char ch = str2.charAt(2);
        System.out.println(ch);
        System.out.println(str2.length());
        char[] chars = str2.toCharArray();
        System.out.println(Arrays.toString(chars));

    }

    public static void main1(String[] args) {
        String str = "hello";
        for (int i = 0; i < 20; i++) {
            str += i;
        }
        System.out.println(str);
    }
}
