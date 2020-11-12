package Sort;
/**
 *@ClassName: SelectSort
 *@Description 选择排序
 *@Author PandaChan1
 *@Date 2020/11/12
 *@Time 10:48
 */


/**
 * 时间复杂度：O(n^2)
 * 空间复杂度:O(1)
 * 稳定性：不稳定，跳跃式交换
 */
public class SelectSort {
    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
