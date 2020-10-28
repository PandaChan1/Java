package Code;


public class StringOption {


    public static String reverseK(String str,int k) {  //字符串反转
        if (str == null || str.length() == 0) {
            return str;
        }
        if (k > str.length() || k <= 0) {
            return null;
        }
        int len = str.length();
        str = reverse(str,0,k - 1);
        str = reverse(str,k,len - 1 );
        return reverse(str);
    }


    public static String reverse(String str,int i,int j) {  //字符串反转
        if (str == null) {
            return null;
        }
        //1、字符串转成数组
        char[] chars = str.toCharArray();
        //2、开始逆置
        while (i < j) {
            //交换
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        //3、返回字符串
//        String ret = "";
//        for (char ch : chars) {
//            ret += ch;
//        }
//        return String.valueOf(chars);
        return new String(chars);
    }


    public static String reverse(String str) {  //字符串反转
        if (str == null) {
            return null;
        }
        //1、字符串转成数组
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        //2、开始逆置
        while (i < j) {
                //交换
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
        }
        //3、返回字符串
//        String ret = "";
//        for (char ch : chars) {
//            ret += ch;
//        }
//        return String.valueOf(chars);
        return new String(chars);
    }


    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverse(str));
        String str1 = "abcdef";
        System.out.println(reverseK(str1, 2));
     /*   String str1  ="  hello world  ";
        System.out.println(str1.trim());

        String str2 = "helloworld";
        System.out.println(str2.substring(5));
        System.out.println(str2.substring(0,5));

        System.out.println(str2.toLowerCase());
        System.out.println(str2.toUpperCase());

        String str3 = "hello";  //存在字符串常量池
        String str4 = new String("hello").intern();  //intern() 将字符串直接放入常量池
        System.out.println(str3 == str4);*/
    }
}
