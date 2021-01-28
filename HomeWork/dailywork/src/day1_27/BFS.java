package day1_27;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *@ClassName: BFS
 *@Description https://www.nowcoder.com/questionTerminal/5017fd2fc5c84f78bbaed4777996213a
 *@Author PandaChan1
 *@Date 2021/1/28
 *@Time 17:32
 */

/*
* 红与黑  BFS遍历
* */
public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            int[][] data = new int[m][n];
            int x = 0;
            int y = 0;
            for (int i = 0; i < m; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    //System.out.print(str.charAt(j) + " ");
                    switch (str.charAt(j)) {
                        case '.':
                            // 可通行
                            data[i][j] = 0;
                            break;
                        case '#':
                            // 不可通行
                            data[i][j] = 1;
                            break;
                        case '@':
                            data[i][j] = 0;
                            x = i;
                            y = j;
                            break;
                    }
                }
            }
            System.out.println(bfs(data,x,y));
        }
    }

    public static int bfs(int[][] data,int startX,int startY) {
        int row = data.length;
        int col = data[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(data[i][j] == 1){
                    visited[i][j] = true;
                    continue;
                }
                visited[i][j] = false;
            }
        }
        Queue<Point> queue = null;
        queue = new ArrayBlockingQueue<Point>(100);
        Point start = new Point(startX, startY);
        int step = 0;
        step++;
        queue.add(start);
        visited[startX][startY] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            // 不是第一行
            if (x != 0 && data[x - 1][y] != 1 && !visited[x-1][y]){
                step++;
                queue.add(new Point(x - 1, y));
                visited[x-1][y] = true;
            }
            // 不是第一列
            if (y != 0 && data[x][y-1] != 1 && !visited[x][y-1]){
                step++;
                queue.add(new Point(x, y - 1));
                visited[x][y-1] = true;
            }
            // 不是最后一行
            if (x != row-1 && data[x +1][y] != 1 && !visited[x+1][y]){
                step++;
                queue.add(new Point(x + 1, y));
                visited[x+1][y] = true;
            }

            // 不是最后一列
            if (y != col-1 && data[x][y+1] != 1 && !visited[x][y+1]){
                step++;
                queue.add(new Point(x, y+1));
                visited[x][y+1] = true;
            }
        }
        return step;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
