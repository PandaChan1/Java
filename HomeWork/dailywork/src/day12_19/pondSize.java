package day12_19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@ClassName: pondSize
 *@Description 面试题16.19  水域大小
 *@Author PandaChan1
 *@Date 2020/12/19
 *@Time 18:34
 */


public class pondSize {
    public int[] pondSizes(int[][] land) {
        int r = land.length;
        int c = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < r;i++) {
            for(int j = 0; j < c;j++) {
                if(land[i][j] == 0) {
                    int temp =  dfs(i,j,land);
                    ans.add(temp);
                }
            }
        }
        Collections.sort(ans);
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length;i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public int dfs(int i,int j,int[][] land) {
        int count = 0;
        if(!check(i,j,land)) {
            return count;
        }

        count++;
        land[i][j] = -1;

        count += dfs(i - 1,j,land);
        count += dfs(i + 1,j,land);
        count += dfs(i,j - 1,land);
        count += dfs(i,j + 1,land);

        count += dfs(i - 1,j - 1,land);
        count += dfs(i - 1,j + 1,land);
        count += dfs(i + 1,j - 1,land);
        count += dfs(i + 1,j + 1,land);

        return count;
    }

    public boolean check(int i,int j,int[][] land) {
        if(i < 0 || j < 0 || i == land.length || j == land[0].length || land[i][j] != 0) {
            return false;
        }else {
            return true;
        }
    }
}
