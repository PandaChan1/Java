package day12_19;

/**
 *@ClassName: rotate
 *@Description leetcode48 旋转图像  思路：主对角线翻转（左上右下） 然后中间对称翻转
 *@Author PandaChan1
 *@Date 2020/12/19
 *@Time 18:32
 */


public class rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n - 1; i++ ) {
            for(int j = i + 1; j < n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int mid = n / 2;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < mid;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
