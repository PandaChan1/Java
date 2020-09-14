package offer;

public class Find {

    /**
     *题目描述：
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下
     * 递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个数，判断数组中是否含有该数。
     * ---------------------------------------------------------------------
     * 思路：
     * 该二维数组上到下递增，左到右递增。总结规律：可以从左下角或者右上角开始查找
     * ---------------------------------------------------------------------
     * 例如：右上角开始
     * 如果右上角等于target则查找结束；如果右上角大于target则删除该列；如果右上角小于target则删除该行
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target,int[][] array){
        if (array==null) {
            return false;
        }
        int row=array.length;
        int col=array[0].length;
        for (int i=row-1,j=0;i>=0&&j<col;){  //左下角开始
            if (target==array[i][j]){
                return true;
            }else if (target<array[i][j]){ //向上移动，跳过该行
                i--;
            }else  //向右移动，跳过该列
             j++;
        }
        return false;
    }
}
