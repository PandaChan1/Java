package day11_24;

import java.util.Stack;

/**
 *@ClassName: Matcher_ascii
 *@Description 括号匹配
 *@Author PandaChan1
 *@Date 2020/11/25
 *@Time 17:43
 */


public class Matcher_ascii {
    public static void main(String[] args) {
        System.out.println(match("(()((6))))"));
    }

    public static boolean match(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
