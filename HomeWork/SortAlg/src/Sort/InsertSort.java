package Sort;

/**
 *@ClassName: InsertSort
 *@Description 插入排序
 *@Author PandaChan1
 *@Date 2020/11/12
 *@Time 9:27
 */

/**
 * 时间复杂度：
 * 最好 O(n)   (n - 1)
 * 最坏 O(n^2)  (n - 1) * (n - 1)
 * 空间复杂度： O(1)
 */

public class InsertSort {
    public static int[] insertSort(int[] array) {
        if (array.length == 0) return null;
        int cur = 0; //只用了一个cur来记录数据  空间为O(1)
        int pre = 0;
        for (int i = 0; i < array.length - 1; i++) {           //循环n - 1 次
            cur = array[i + 1]; //默认第一个已经有序，从第二个元素开始
            pre = i;  //保存前一个元素的下标
            while(pre >= 0 && cur < array[pre]) {          //最坏循环n - 1次
                //当前元素小于前一个
                array[pre + 1] = array[pre];  //pre + 1 = i,i位置赋为pre的元素
                pre--;
            }
            //当pre<0时，跳出循环
            array[pre + 1] = cur;
        }
        return array;
    }
}
