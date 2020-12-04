package day12_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buildMultiArray {
    public static void main(String[] args) {
        buildMultiArray b = new buildMultiArray();
        System.out.println(b.multiply(new int[]{1, 2, 3, 4}));
    }
    List<Integer> tmp = new ArrayList<>();
    public int[] multiply(int[] A) {
        for (int i = 0; i < A.length; i++) {
           int[] left =  Arrays.copyOfRange(A,0,i);
           int[] right = Arrays.copyOfRange(A,i + 1,A.length);
           tmp.add( count(left,right));
        }
        int[] B = new int[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            B[i] = tmp.get(i);
        }
        return B;
    }

    public int count(int[] left,int[] right) {
        int ans = 1;
        if (left.length == 0) {
            for (int i :
                    right) {
                ans *= i;
            }
            return ans;
        }else if (right.length == 0) {
            for (int i :
                    left) {
                ans *= i;
            }
            return ans;
        }else {
            for (int i :
                    right) {
                ans *= i;
            }

            for (int i :
                    left) {
                ans *= i;
            }

            return ans;
        }
    }
}
