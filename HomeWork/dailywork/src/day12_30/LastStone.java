package day12_30;

/**
 *@ClassName: LastStone
 *@Description leetcode  最后一块石头的重量
 *@Author PandaChan1
 *@Date 2020/12/30
 *@Time 23:25
 */


import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {
    public int lastStoneWeight(int[] stones) {
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
}
