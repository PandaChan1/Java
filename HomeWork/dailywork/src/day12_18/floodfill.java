package day12_18;

/**
 *@ClassName: floodfill
 *@Description 733 图像渲染 dfs
 *@Author PandaChan1
 *@Date 2020/12/18
 *@Time 19:22
 */


public class floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int cur = image[sr][sc];
        if(cur != newColor) {
            dfs(image,sr,sc,cur,newColor);
        }
        return image;
    }


    public void dfs(int[][] image,int i,int j,int cur,int newColor) {
        if(i < 0 || i == image.length || j < 0 || j == image[0].length || image[i][j] != cur) {
            return;
        }else {
            image[i][j] = newColor;

            dfs(image,i + 1, j,cur,newColor);
            dfs(image,i - 1, j,cur,newColor);
            dfs(image,i, j + 1,cur,newColor);
            dfs(image,i, j - 1,cur,newColor);
        }
    }
}
