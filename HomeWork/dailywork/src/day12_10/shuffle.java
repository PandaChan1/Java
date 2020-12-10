package day12_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shuffle {
   static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n > 0) {

                int t = Integer.parseInt(sc.next());
                int times = Integer.parseInt(sc.next());

                int[] array = new int[t*2];

                for (int j = 0; j < t * 2; j++) {
                    int m = Integer.parseInt(sc.next());
                    array[j] = m;
                }


                helper(array,times);

                list.add(array);

            n--;

        }


        for (int[] i :
                list) {

            for (int j = 0; j < i.length; j++) {
                if (j == 0) {
                    System.out.print(i[j]);
                }else {
                    System.out.print(" " + i[j]);
                }
            }
            System.out.println();
        }


    }

    public static void helper(int[] array,int n) {
        for (int i = 0; i < n; i++) {
            flush(array);
        }
    }

    public static void flush(int[] array) {
        int len = array.length;
        int[] left = Arrays.copyOfRange(array,0,len/2);
        int[] right = Arrays.copyOfRange(array,len/2,len);

        int toleft = 0;
        int toright = 0;

        for (int i = 0; i < len;) {
            array[i++] = left[toleft++];
            array[i++] = right[toright++];
        }
    }
}
