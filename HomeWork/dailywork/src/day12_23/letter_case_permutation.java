package day12_23;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName: letter_case_permutation
 *@Description leetcode 784  字母大小写全排列 dfs
 *@Author PandaChan1
 *@Date 2020/12/23
 *@Time 17:48
 */


public class letter_case_permutation {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        letter_case_permutation l = new letter_case_permutation();
        System.out.println(l.letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) return ans;

        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        dfs(chars,0);


        return ans;
    }

    private void dfs(char[] s,  int n) {
       if (n == s.length) {
           ans.add(new String(s));
           return;
       }

        dfs(s,n + 1);
       if (Character.isLetter(s[n])) {
           s[n] ^= 1 << 5;
           dfs(s,n + 1);
       }
    }
}
