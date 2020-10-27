package Code;

public class MyReplace {
    public static String myReplace(String str, String replaced, String spx) {
        int len = str.length();

        String ret = "";
        for (int i = 0; i < len; i++) {
            if ((str.charAt(i) + "").equals(replaced)) {
                ret += spx;
            } else {
                ret += str.charAt(i);
            }
        }
        return ret;
    }

    public static int myIndexOf(String str, String sub) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == sub.charAt(0)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(String str, String dest) {
        int len = str.length();
        int j = 0;
        for (int i = 0; i < len; ) {
            while (str.charAt(i) == dest.charAt(j)) {
                i++;
                j++;
                if (j == dest.length()) {  //j == length即表明找到了一个，返回true
                    return true;
                }
            }

            //j == length - 1 当最后一个不匹配时，要先回退一步，因为最后一个可能和开头匹配
            if (j == dest.length() - 1 && dest.length() != 1) {  //只有一个元素时，直接跳过
                i--;
                j = 0;
            }
            i++;
        }
        return false;
    }

    public static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int count = 0;
        int i  = 0;
        while(i < len1 && len1 == len2) {

                if (str1.charAt(i) > str2.charAt(i)) {
                    count++;
                } else if (str1.charAt(i) < str2.charAt(i)) {
                    count--;
                }
                if (i == len1 - 1) {
                return count;
                }else{
                    i++;
                }


        }

        return len1 - len2;
    }

    public static void main(String[] args) {
        String str = "wangl";
//        String s = myReplace(str, "u", "o");
//        System.out.println(s);
//        System.out.println(myIndexOf(str, "l"));
//        System.out.println(contains(str, "l"));
        System.out.println(compareTo(str, "wadad"));
    }
}
