package day12_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class minNum {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            List<Integer> list = new ArrayList<>();
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int n = 0;
            boolean flg = false;
            for (int i = 0; i < s.length; i++) {

                if (Integer.parseInt(s[i]) > 0) {
                    if (n == 0) {
                        flg = true;
                    }

                    for (int j = 0; j < Integer.parseInt(s[i]); j++) {
                        list.add(n);
                    }

                }
                n++;
            }

            if (flg) {
                int index = 1;
                while(index < list.size()) {
                    if (list.get(index) > list.get(0)) {
                        break;
                    }
                    index++;
                }

                int temp = list.get(0);
                list.set(0,list.get(index));
                list.set(index,temp);
            }

            StringBuilder sb = new StringBuilder();

            for (int t :
                    list) {
                sb.append(t);
            }

            System.out.println(sb.toString());
        }
    }
}


class old{
//     while(sc.hasNext()) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int i = 0;
//        boolean flg = false;
//
//        while(i < 9) {
//            int n = Integer.parseInt(sc.next());
//            if (n > 0) {
//                if (i == 0) {
//                    flg = true;
//                }
//                for (int j = 0; j < n; j++) {
//                    list.add(i);
//                }
//            }
//            i++;
//        }
//
//
//        if (flg) {
//            int index = 1;
//            while(index < list.size()) {
//                if (list.get(index) > list.get(0)) {
//                    break;
//                }
//                index++;
//            }
//
//            int temp = list.get(0);
//            list.set(0,list.get(index));
//            list.set(index,temp);
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int t :
//                list) {
//            sb.append(t);
//        }
//
//        System.out.println(sb.toString());
//    }
}
