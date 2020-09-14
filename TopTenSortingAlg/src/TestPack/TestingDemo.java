package TestPack;

import SortAlg.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestingDemo {
    @Before
    public void setUp() throws Exception{
        System.out.println("测试数据为：");
        for (int i :
                myData.array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("正确输出结果为：");
        for (int i :
                myData.result) {
            System.out.print(+i + ", ");
        }
    }
    @Test
    public void testSortResult(){
//       int[] result=BubbleSort.BubbleSort(myData.array);
//        int[] result= selectionSort.selectionSort(myData.array);
//        int[] result= InsertionSort.insertionSort(myData.array);
//        int[] result= ShellSort.shell(myData.array);
          int[] result=MergeSort.Mergesort(myData.array);
        Assert.assertArrayEquals(result,myData.array);
      System.out.println("测试结果为:");
        for (int i :
                result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
