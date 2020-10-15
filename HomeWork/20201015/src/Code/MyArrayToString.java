package Code;

import Data.MyArray;

/**
 *@ClassName: MyArrayToString
 *@Description 将数组转成字符串，手动实现Arrays.toStirng()方法
 *@Author PandaChan1
 *@Date 2020/10/15
 *@Time 12:06
 */


public class MyArrayToString {
    public static void main(String[] args) {
        int[] array = MyArray.MY_ARRAY;
        System.out.println(myArrayToString(array));
    }
    private static String myArrayToString(int[] array) {
        //判空
        if (array == null) {
            return "";
        }
        //判断空数组
        if (array.length == 0) {
            return "[]";
        }
        String start = "[";
        String end = "]";
        String res = start+"";

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                res = res + array[i] + end;
            }else {
                res = res + array[i] + ",";
            }
        }
        return res;
    }
}
