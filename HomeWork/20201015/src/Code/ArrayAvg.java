package Code;

import Data.ArrayForAvg;
import Data.MyArray;

import java.util.Arrays;

public class ArrayAvg {

    public static void main(String[] args) {
        System.out.println(svg(ArrayForAvg.ARRAY_FOR_AVG));
        System.out.println(sum(ArrayForAvg.ARRAY_FOR_AVG));
        System.out.println(Arrays.toString(transform(ArrayForAvg.ARRAY_FOR_AVG)));
        printArray(ArrayForAvg.ARRAY_FOR_AVG);
        System.out.println();
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        for (int i :
                numbers) {
            System.out.print(i + " ");
        }
    }

    private static void printArray(int[] arrayForAvg) {
        for (int i :
                arrayForAvg) {
            System.out.print(i+" ");
        }
    }

    private static int[] transform(int[] arrayForAvg) {
        int[]  res = new int[arrayForAvg.length];
        for (int i = 0; i < arrayForAvg.length; i++) {
            res[i] = arrayForAvg[i] * 2;
        }
        return res;
    }

    private static int sum(int[] arrayForAvg) {
        int sum = 0;
        for (int i :
                arrayForAvg){
            sum = sum + i;
        }
        return sum;
    }

    private static double svg(int[] myArray) {
        double res = 0;
        for (int i :
                myArray)
            res = res + i;
        return res / myArray.length;
    }

}
