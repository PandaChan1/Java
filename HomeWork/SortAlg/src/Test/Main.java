package Test;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main{
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String str = sc.nextLine();
//            String[] splits = str.split("[^0-9]");
//            String res = "";
//            for(int i = 0; i < splits.length;i++) {
//                if(splits[i].length() > res.length()) {
//                    res = splits[i];
//                }
//            }
//            System.out.print(res);
//        }
        arr();
    }



        public static void arr( ) {
            String obj  = "abc";
            byte b[] = obj.getBytes();
            ByteArrayInputStream obj1 = new ByteArrayInputStream(b);
            for (int i = 0; i < 2; ++ i) {
                int c;
                while ((c = obj1.read()) != -1) {
                    if (i == 0) {
                        System.out.print(Character.toUpperCase((char)c));
                    }
                }
            }
        }


        public static void testMap() {
        HashMap<Integer,String> hashMap = new HashMap<>();
            ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>();
        }

}