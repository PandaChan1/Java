package Sort;

/**
 *@ClassName: ShellSort
 *@Description 希尔排序
 *@Author PandaChan1
 *@Date 2020/11/12
 *@Time 10:21
 */

/**
 *稳定性：不稳定，跳跃式排序
 * 时间复杂度：O(n^1.3) - O(n^1.5)
 * 空间复杂度：O(1) 只用了一个cur记录数据
 */
public class ShellSort {
    public static int[] shellSort(int[] array) {
        if (array.length == 0) return null;
        int gap = array.length / 2;
        int cur = 0;
        while(gap > 0) {
            for (int i = gap; i < array.length; i++) {
                cur = array[i];
                int pre = i - gap;
                while (pre >= 0 && cur < array[pre]) {
                    array[pre + gap] = array[pre];
                    pre -=gap;
                }
                array[pre + gap] = cur;
            }
            gap /=2;
        }
        return array;
    }


        //希尔排序
    public static void anotherShell(int[] array, int gap) {
    if (array.length == 0) return;
    int cur = 0;
        for (int i = gap; i < array.length; i++) {
            cur = array[i];
            int pre = i - gap;
            while(pre >= 0 && cur < array[pre]) {
                array[pre + gap] = array[pre];
                pre -= gap;
            }
            array[pre + gap] = cur;
        }
    }

    public static int[] shell(int[] array) {  //提前设置步长，然后循环排序
        int[] gap = {5,3,1};
        for (int i = 0; i < gap.length; i++) {
            anotherShell(array,gap[i]);
        }
        return array;
    }

}
