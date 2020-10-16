package Code;

import Data.MyArray;

import java.util.Arrays;

/**
 *@ClassName: CopyString
 *@Description 数组拷贝方法
 *@Author PandaChan1
 *@Date 2020/10/16
 *@Time 9:24
 */


public class CopyString {
    public static void main(String[] args) {

        //方法一
       /* int[] copy = new int[MyArray.MY_ARRAY.length];
        for (int i = 0; i < MyArray.MY_ARRAY.length; i++) {
            copy[i] = MyArray.MY_ARRAY[i];
        }*/


        //方法二
        //int[] copy = Arrays.copyOf(MyArray.MY_ARRAY, MyArray.MY_ARRAY.length);


        //方法三
        int[] copy1 = new int[MyArray.MY_ARRAY.length];
        System.arraycopy(MyArray.MY_ARRAY,0,copy1,0,MyArray.MY_ARRAY.length);
        System.out.println(Arrays.toString(copy1));

        //方法四
        //深拷贝：改变拷贝后的数组，原数组的内容不会改变。因为原数组中存储的是数值类型
        //浅拷贝：改变拷贝之后的数组，原数组的内容也会改变。因为原数组中存储的是 **对象（引用类型）** 而不是数值类型
        //clone()就是浅拷贝
        int[] copy2 = MyArray.MY_ARRAY.clone();
        System.out.println(Arrays.toString(copy2));


        //求数组中的最大值
        maxNum(MyArray.MY_ARRAY);
    }
    private static void maxNum(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int max = array[0];
        for (int i = 0;i < array.length;i ++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
