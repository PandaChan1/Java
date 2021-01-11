package day1_8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName: MaxScore
 *@Description 牛客oj  最高分是多少
 *@Author PandaChan1
 *@Date 2021/1/11
 *@Time 15:26
 */


public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();  //学生数目
            int m = sc.nextInt();  //操作数目
            int[] stus = new int[n];
            //存储学生成绩
            for (int i = 0; i < n; i++) {
                stus[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                String c = sc.next();

                int a = sc.nextInt();

                int b = sc.nextInt();
                if ("Q".equals(c)) {
                    if(a > b)
                    {
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    int res = helper(a, b, stus);
                    System.out.println(res);
                }else {
                    stus[a - 1] = b;
                }
            }
        }

    }

    private static int helper( int a, int b, int[] stus) {
            int[] ints = Arrays.copyOfRange(stus, a - 1, b);
            Arrays.sort(ints);
          return ints[ints.length - 1];
    }
}
