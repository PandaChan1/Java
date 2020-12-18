package day12_18;

/**
 *@ClassName: solve
 *@Description 130 被围绕的区域 dfs
 *@Author PandaChan1
 *@Date 2020/12/18
 *@Time 19:23
 */


public class solve {
    public void solve(char[][] board) {

        if(board == null || board.length == 0) {
            return;
        }

        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r;i++) {
            dfs(board,i,0);
            dfs(board,i,c - 1);
        }

        for(int i = 1; i < c-1;i++) {
            dfs(board,0,i);
            dfs(board,r - 1,i);
        }

        for(int i = 0; i < r;i++) {
            for(int j = 0; j < c;j++) {
                if(board[i][j] == 'Q') {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board,int i,int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'Q';

        dfs(board,i - 1,j);
        dfs(board,i + 1,j);
        dfs(board,i,j - 1);
        dfs(board,i,j + 1);
    }
}
