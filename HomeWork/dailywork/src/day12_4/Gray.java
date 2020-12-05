package day12_4;

import java.util.Arrays;

/**
 *@ClassName: day12_4.day12_4
 *@Description 生成格雷码,按照给定的n
 *@Author PandaChan1
 *@Date 2020/12/5
 *@Time 20:30
 */


public class Gray {
    public static void main(String[] args) {
        Gray g = new Gray();
        System.out.println(Arrays.toString(g.gray(3)));
    }
    public String[] gray(int n) {
        if (n == 1) {
            return new String[]{"0","1"};
        }

        String[] pre = gray(n - 1);
        String[] ans = new String[pre.length * 2];

        for (int i = 0; i < pre.length;i++) {
            ans[i] = "0" + pre[i];
            ans[ans.length - 1 - i] = "1" + pre[i];
        }
        return ans;
    }
}
