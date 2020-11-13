package PriorityQueueDemo;

import java.util.Arrays;

public class PriorityQueueTest {
    //向下调整，每次都是从最后一个节点的父节点开始调整
    public static void adjustDown(int[] array,int parent,int len) {
    int child = parent * 2 + 1;  //左孩子
        while(child < len) {
            //判断是否有右孩子，并找出左右孩子的最大值的下标
            if (child + 1 < len && array[child] < array[child + 1] ) {
                child ++;
            }
            //child中存储的就是最大值的下标
            if (array[child] > array[parent]) {  //大堆,左右节点最大值和父节点交换
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                //交换完成后
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    //向上调整每次都是从最后一个节点，插入调整
    public static void adjustUp(int[] array,int child) {
    //child是最后一个节点的下标
        int parent = (child - 1) / 2;
        while(child > 0) {  //调整到0下标即根节点就不调整了
            if(array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                //交换完毕
                child = parent;
                parent = (child - 1) / 2;

            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        int len = array.length;
        //向下调整建堆，每次从最后一个节点的父节点开始
        //len - 1 是最后一个节点的下标   (len - 1 - 1 ) / 2   就等价于  parent = (child - 1) / 2
        for (int i = (len - 1 - 1) / 2; i  >= 0; i--) {
            adjustDown(array,i,len);
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{25,7,12,3,83,31}));
        createHeap(new int[] {25,7,12,3,83,31});
    }
}
