package day1_13;

import java.util.Scanner;

public class ScoreGpa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();   //总科数
            int sum = 0;  //所有课程学分之和
            float sumGpa = 0;
            int[] array =  new int[n];   //存储学分

            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                array[i] = tmp;
                sum += tmp;
            }

            for (int i = 0; i < n; i++) {   //存储各科成绩
                int score = sc.nextInt();
                if (score < 60) {
                    sumGpa += 0;
                }else if (score <= 63){
                    sumGpa += array[i] * 1.0;
                }else if (score <= 67) {
                    sumGpa += array[i] * 1.5;
                }else if (score <= 71) {
                    sumGpa += array[i] * 2.0;
                }else if (score <= 74) {
                    sumGpa += array[i] * 2.3;
                }else if (score <= 77) {
                    sumGpa += array[i] * 2.7;
                }else if (score <= 81) {
                    sumGpa += array[i] * 3.0;
                }else if (score <= 84) {
                    sumGpa += array[i] * 3.3;
                }else if (score <= 89) {
                    sumGpa += array[i] * 3.7;
                }else{
                    sumGpa += array[i] * 4.0;
                }
            }

            System.out.printf("%.2f",sumGpa / sum);

        }
    }
}
