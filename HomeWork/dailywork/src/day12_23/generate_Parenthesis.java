package day12_23;

import java.util.ArrayList;
import java.util.List;
/**
 *@ClassName: generate_Parenthesis
 *@Description leetcode 22  括号生成  dfs和回溯都可解
 *@Author PandaChan1
 *@Date 2020/12/23
 *@Time 18:26
 */


public class generate_Parenthesis {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        generate_Parenthesis g = new generate_Parenthesis();
        System.out.println(g.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        if(n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(sb,n,n);
        return ans;
    }

    private void dfs(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0){
            ans.add(sb.toString());
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            sb.append("(");
            dfs(sb,left - 1,right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            sb.append(")");
            dfs(sb,left,right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
