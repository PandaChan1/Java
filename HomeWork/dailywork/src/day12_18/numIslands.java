package day12_18;

/**
 *@ClassName: numIslands
 *@Description 200 岛屿数量 dfs
 *@Author PandaChan1
 *@Date 2020/12/18
 *@Time 19:23
 */


public class numIslands {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int ans = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid,int r,int c) {
        if(check(grid,r,c)) {
            return;
        }

        grid[r][c] = '0';

        dfs(grid,r - 1,c);
        dfs(grid,r + 1,c);
        dfs(grid,r,c - 1);
        dfs(grid,r,c + 1);
    }



    public  boolean check(char[][] grid,int r,int c) {
        return r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == '0';
    }
}
