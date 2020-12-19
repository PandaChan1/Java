package day12_19;

/**
 *@ClassName: exist
 *@Description 单词搜索 回溯法
 *@Author PandaChan1
 *@Date 2020/12/19
 *@Time 18:35
 */


public class exist {
    boolean[][] visited;
    int[][] option;
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        visited = new boolean[r][c];
        option = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

        if(word == null || r == 0) {
            return false;
        }

        for(int i = 0; i < r;i++) {
            for(int j = 0; j < c;j++) {
                if(dfs(i,j,0,word,board)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int i,int j,int start,String word,char[][] board) {
        if(start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        if(board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for(int p = 0; p < 4; p++) {
                int x = i + option[p][0];
                int y = j + option[p][1];
                if(check(x,y,board) && !visited[x][y]) {
                    if(dfs(x,y,start + 1,word,board)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;

    }

    public boolean check(int i , int j,char[][] board) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}
