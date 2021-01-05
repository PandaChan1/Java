package day1_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *@ClassName: SubStr
 *@Description 子串判断  子串：串中任意连续个字符组成,注意连续
 * 思路： 和全排列类似，回溯算法求全排列，放到set中，然后挨个判断
 *@Author PandaChan1
 *@Date 2021/1/5
 *@Time 19:59
 */

public class SubStr {

    public static void main(String[] args) {
        SubStr s = new SubStr();
        String[] strs = new String[] {"a","b","c","d","ab","ac",""};
        String str = "abc";
        System.out.println(Arrays.toString(s.chkSubStr(strs, 7, str)));

    }
//答案
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.contains(p[i]);
        }
        return res;
    }

    //我的
    public boolean[] MychkSubStr(String[] p, int n, String s) {
        // write code here
        Set<String> sets = new HashSet<>();
        boolean[] res = new boolean[n];
        StringBuilder sb = new StringBuilder();
        dfs(s,0,sets,sb);
        for (int i = 0; i < p.length; i++) {
            char[] chars = p[i].toCharArray();
            Arrays.sort(chars);
            String ss = new String(chars);
            if (sets.contains(ss)) {
                res[i] = true;
            }
        }
        return res;
    }

    public void dfs(String s, int n,Set set,StringBuilder sb) {
        set.add(sb.toString());
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(s,i + 1,set,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
