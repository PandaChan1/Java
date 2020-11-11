package Question;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *@ClassName: find_k_pairs_with_smallest_sums
 *@Description 查找和最小的k对数字
 *@Author PandaChan1
 *@Date 2020/11/10
 *@Time 18:02
 */


public class find_k_pairs_with_smallest_sums {
    public static List<List<Integer>> findkpairswithsmallestsums(int[] nums1,int[] nums2,int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(0) + o1.get(1)) - (o2.get(0) + o2.get(1));
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k,nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.offer(list);
            }
        }
        int size = queue.size();
        for (int i = 0; i < Math.min(size,k); i++) {
            res.add(queue.poll());
        }
            return res;
        }
        public static void main(String[] args) {

    }
    }


