import java.util.Scanner;


class test{
    public static void hello(){
        System.out.println("hello");
    }
}
public class StringTest {
    public static void main(String[] args) {
        test test1 = null;
        test1.hello();
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int len = str.length();
        String res = "";
//        for (int i = 0; i < len; i++) {
//            while(!res.contains(str.charAt(i) + "")) {
//                res  += str.charAt(i);
//            }
//        }
//        System.out.println(res);
        StringBuilder sb = new StringBuilder(res);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            String tmp = "" + c;
            while(!res.contains(tmp)) {
                sb.append(tmp);
                res = res + tmp;
            }
        }
        System.out.println(res);
    }
}
