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

    public static void main(String[] args) {
        String[] str = {"4","13","5","/","+"};
        System.out.println(evalRPN(str));
    }
}
