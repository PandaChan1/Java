package LeetCode.动态规划;

/**
 *@ClassName: longest_circle_substring
 *@Description 最长回文子串
 *@Author PandaChan1
 *@Date 2021/3/5
 *@Time 15:42
 */

//动态规划
public class longest_circle_substring {
    public static void main(String[] args) {
        solution("abbabdacdbad");
    }

    public static void solution(String s) {
        int len = s.length();
        if (len < 2) {
            System.out.println(s);
        }


        //二维数组，用来记录[i...j]是否为回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len;j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {   //[i..j]不是回文串
                    dp[i][j] = false;
                }else {
                    //i，j相等
                    //此时如果j - i < 3，说明[i...j]之间只有一个数字，[i...j]必是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else {
                        //否则，就要看[i + 1,j - 1]是否相等了
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }


                //如果dp[i][j] == true,且长度比max大，那么就记录起始位置和长度
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        System.out.println(s.substring(start,start + maxLen));
    }
}
