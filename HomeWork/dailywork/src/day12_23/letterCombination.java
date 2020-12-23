package day12_23;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName: letterCombinations
 *@Description leetcode17  电话号码的字母组合 回溯
 *@Author PandaChan1
 *@Date 2020/12/23
 *@Time 15:56
 */


public class letterCombination {
    List<String> ans = new ArrayList<>();
    String[] strs = new String[8];

    public static void main(String[] args) {
        letterCombination l = new letterCombination();
        System.out.println(l.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        strs[0] = "abc";
        strs[1] = "def";
        strs[2] = "ghi";
        strs[3] = "jkl";
        strs[4] = "mno";
        strs[5] = "pqrs";
        strs[6] = "tuv";
        strs[7] = "wxyz";

        StringBuilder sb = new StringBuilder();
        dfs(digits,strs,0,sb);

        return ans;
    }

    private void dfs(String src, String[] array, int n, StringBuilder sb) {
        if (sb.length() == src.length()) {  //找到一个解
            String string = sb.toString();
            ans.add(string);
            return;
        }

        int index = src.charAt(n) - '0' - 2;

        for (int i = 0; i < array[index].length(); i++) {
            sb.append(array[index].charAt(i));
            dfs(src,array,n + 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
