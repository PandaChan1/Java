package day12_25;

import java.util.Arrays;

/**
 *@ClassName: findContentChildren
 *@Description leetcode 455 分发饼干
 *@Author PandaChan1
 *@Date 2020/12/25
 *@Time 16:10
 */


public class find_Content_Children {
    public static void main(String[] args) {
        find_Content_Children f = new find_Content_Children();
        System.out.println(f.findContentChildren(new int[]{1, 2}, new int[]{
                1, 2,3
        }));
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        int ans = 0;
        while(gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                si++;
                gi++;
                ans++;
            }else {
                gi++;
            }
        }
        return ans;
    }
}
