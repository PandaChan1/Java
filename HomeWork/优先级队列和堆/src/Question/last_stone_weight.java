package Question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *@ClassName: last_stone_weight
 *@Description 最后一块石头的重量,大顶堆
 *@Author PandaChan1
 *@Date 2020/11/10
 *@Time 17:47
 */


public class last_stone_weight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }

        while(queue.size() >= 2) {
            int q1 = queue.poll();
            int q2 = queue.poll();
           if (q1 != q2){
                queue.offer(Math.abs(q1- q2));
            }else {
               queue.offer(0);
           }
        }
        return queue.poll();
    }
    public static void main(String[] args) {
        int[] stones = {1,1};
        System.out.println(lastStoneWeight(stones));

    }
}
