package com.pandachen.Util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    // 写一个泛型方法
    // list1 - list2
    public static <E> List<E> differenceSet(List<E> list1, List<E> list2) {
        List<E> resultList = new ArrayList<>();

        for (E item : list1) {
            if (!list2.contains(item)) {    // E 类型必须正确地支持 equals 方法
                resultList.add(item);
            }
        }

        return resultList;
    }
}
