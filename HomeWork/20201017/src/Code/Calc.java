package Code;

import java.util.Scanner;

/**
 *@ClassName: Calculator
 *@Description 四则运算计算器类
 *@Author PandaChan1
 *@Date 2020/10/18
 *@Time 18:55
 */


class Calculator {
    //成员属性
    private int num1;
    private int num2;
    //构造方法
    public Calculator() {

    }
    public Calculator(int a,int b) {
        this.num1 = a;
        this.num2 = b;
    }
    //getter和setter
    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return this.num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }


    //成员方法
    public int add(int a, int b) {
        return a + b;
    }
    public int minus(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }

    //重载无参成员方法
    public int add() {
        return this.num1 + this.num2;
    }
    public int minus() {
        return this.num1 - this.num2;
    }
    public int multiply() {
        return this.num1 * this.num2;
    }
    public int divide() {
        return this.num1 / this.num2;
    }


    //toString()重写
    @Override
    public String toString() {
        return "Calculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
public class Calc {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("加法" + cal.add(a,b) + "  减法" + cal.minus(a,b) + "  乘法" + cal.multiply(a,b) + "  除法" + cal.divide(a,b));


        Calculator cal1 = new Calculator(a,b);
        System.out.println("加法" + cal1.add() + "  减法" + cal1.minus() + "  乘法" + cal1.multiply() + "  除法" + cal1.divide());
        sc.close();
    }
}
