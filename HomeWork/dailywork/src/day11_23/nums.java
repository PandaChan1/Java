package day11_23;

/**
 *@ClassName: nums
 *@Description 数组中的逆序对
 *@Author PandaChan1
 *@Date 2020/11/25
 *@Time 17:04
 */


public class nums {
    public static int count(int[] A, int n) {
        // write code here
        int count = 0;
        for(int i = n - 1;i >= 0 ; i--) {
            int temp = A[i];
            for(int j = 0;j < i;j++) {
                if(A[j] > temp) {
                    count++;
                }
            }
        }
        return count;
    }
}
