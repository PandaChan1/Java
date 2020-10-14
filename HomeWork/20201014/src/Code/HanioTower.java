package Code;

import java.util.Scanner;
/**
 *@ClassName: HanioTower
 *@Description 求解汉诺塔问题
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 19:15
 */


public class HanioTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入汉诺塔的阶数(默认三个柱子，初始全部在A柱子)");
        int n = sc.nextInt();
        Hanio(n,'A','B','C');
    }
    private static void move(char pos1,char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    private static void Hanio(int n,char pos1,char pos2,char pos3) {
        if (n == 1) {
            move(pos1,pos3);
            return;
        }
        Hanio(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        Hanio(n-1,pos2,pos1,pos3);
    }
}
