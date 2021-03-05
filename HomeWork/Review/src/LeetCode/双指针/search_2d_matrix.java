package LeetCode.双指针;

/**
 *@ClassName: search_2d_matrix
 *@Description 搜索二维矩阵
 *@Author PandaChan1
 *@Date 2021/3/5
 *@Time 16:35
 */

//同样用到缩减空间法,双指针

   /*
   矩阵的特性
   每行的元素从左到右升序排列。
      每列的元素从上到下升序排列。*/
    //从左下，右上搜索
    //因为左下，向上递减，向左递增  右上，向下递增，向右递减
    //其它两个角，都是递增或递减的
public class search_2d_matrix {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 1}}, 0));
    }

    public static boolean solution(int[][] map,int target) {
        //左下开始
    int i = map.length - 1;  //最后一行
    int j = 0;  //第一列
    while(i >= 0 && j <= map[0].length - 1) {
        if (map[i][j] > target) {
            i--;
        }else if (map[i][j] < target){
            j++;
        }else {
            return true;
        }
    }
    return false;
    }
}
