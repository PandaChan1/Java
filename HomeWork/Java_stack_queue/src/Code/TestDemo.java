package Code;

import java.util.Stack;

/**
 *@ClassName: TestDemo
 *@Description 逆波兰表达式
 *@Author PandaChan1
 *@Date 2020/11/3
 *@Time 21:13
 */


public class TestDemo {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> ex = new Stack();
        for(int p = 0;p < tokens.length;p++) {

                switch(tokens[p]) {
                    case "+":
                        ex.push(ex.pop() + ex.pop());
                        break;
                    case "-":
                        int mul1 = ex.pop();
                        int mul2 = ex.pop();
                        ex.push(mul2 - mul1);
                        break;
                    case "*":
                        ex.push(ex.pop() * ex.pop());
                        break;
                    case "/":
                        int div1 = ex.pop();
                        int div2 = ex.pop();
                        ex.push(div2 / div1);
                        break;
                    default:
                        ex.push(Integer.parseInt(tokens[p]));
                        break;
                }
        }
        return ex.pop();
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0;i < S.length();i++) {
            if(S.charAt(i) == '#') {
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }
            }else {
                stack1.push(S.charAt(i));
            }

        }

        for(int i = 0;i < T.length();i++) {
            if(T.charAt(i) == '#') {
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }else {
                stack2.push(T.charAt(i));
            }

        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(char c : stack1) {
            sb1.append(c);
        }

        for(char c : stack2) {
            sb2.append(c);
        }

        if(sb1.equals(sb2)) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
//        String[] str = {"4","13","5","/","+"};
//        System.out.println(evalRPN(str));
        String str1 = "ad#c";
        String str2 = "ab#c";
        System.out.println(backspaceCompare(str1, str2));
    }
}
