package Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TOPK {
    public static void topK(int[] array,int k) {
        //求前k小，建大堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //求前k小，建容量为k的大堆，然后将剩余的元素与堆顶比较
        //小于堆顶元素则poll堆顶元素，然后offer
        for (int i = 0; i < array.length; i++) {
            while(priorityQueue.size() < k) {
                priorityQueue.offer(array[i]);
            }
            int top = priorityQueue.peek();

            if (array[i] < top) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }

        System.out.println(priorityQueue.toString());
    }
    public static void main(String[] args) {
        int[] array = {12,45,2,7,10,8,19,56,32};
        topK(array,5);
    }
}
