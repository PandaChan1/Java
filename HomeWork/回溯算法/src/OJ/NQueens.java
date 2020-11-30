package OJ;


import java.util.ArrayList;
import java.util.List;
/**
 *@ClassName: NQueens
 *@Description 回溯法解决n后问题  https://leetcode-cn.com/problems/n-queens/
 *@Author PandaChan1
 *@Date 2020/11/30
 *@Time 9:58
 */


public class NQueens {
    private int n;
    private List<List<String>> res;

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        System.out.println(queens.nQueen(4).toString());
    }
    private  List<List<String>> nQueen(int n) {
        this.res = new ArrayList<>();
        if (n == 0) return  res;
        this.n = n;
        int[] queen = new int[n];
        dfs(queen,0);
        System.out.println(215415);
        return res;
    }

    private void dfs(int[] queen, int row) {
        if (row == n) {  //找到一个解
            covert(queen);
            return;
        }

        for(int i = 0; i < n;i++) {
            if (!check(queen,row,i)) {
                continue;
            }else {
                queen[row] = i;
                dfs(queen,row + 1);
                queen[row] = -1;
            }
        }
    }

    private void covert(int[] queen) {
        List<String> temp = new ArrayList<>();
        for (int i :
                queen) {
            StringBuilder sb = new StringBuilder();
            //java11中开始提供String.repeat方法用来复制字符串
//            sb.append(".".repeat(Math.max(0,n)));
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            sb.replace(i,i + 1,"Q");
            temp.add(sb.toString());
        }
        res.add(temp);
    }


    private boolean check(int[] queen, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col) {
                return false;
            }
        }

        for (int i = 0; i < row; i++) {
            if (row - i == Math.abs(col - queen[i])) {
                return false;
            }
        }
        return true;
    }

}
