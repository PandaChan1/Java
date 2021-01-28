package day1_27;

import java.util.Scanner;

/**
 *@ClassName: DP
 *@Description 蘑菇阵 DP  https://www.nowcoder.com/questionTerminal/ed9bc679ea1248f9a3d86d0a55c0be10
 *@Author PandaChan1
 *@Date 2021/1/28
 *@Time 17:35
 */


public class DP {
    //直接用概率进行DP，用路径数是不对的

        public static void main(String[] args){
            Scanner sca = new Scanner(System.in);
            while(sca.hasNext()){
                int n = sca.nextInt();
                int m = sca.nextInt();
                int k = sca.nextInt();
                boolean[][] map = new boolean[n][m];
                for(int i = 0; i < k; i++) {
                    int x = sca.nextInt()-1;
                    int y = sca.nextInt()-1;
                    map[x][y] = true;
                }
                double[][] cw = new double[n][m];
                cw[0][0] = 1;
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(map[i][j]) cw[i][j] = 0;
                        else if(i == 0 && j == 0) {}
                        else cw[i][j] = (j-1<0?0:(i+1<n?cw[i][j-1]*0.5:cw[i][j-1]))+(i-1<0?0:(j+1<m?cw[i-1][j]*0.5:cw[i-1][j]));
                        //System.out.print(String.format("%.5f",cw[i][j])+" ");
                    }
                    //System.out.println();
                }
                double res = cw[n-1][m-1];
                System.out.println(String.format("%.2f", res));
            }
        }
}
