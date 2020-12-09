package day12_9;

/**
 * 另类加法，不使用算数运算符
 * 对1 2 而言，转换成二进制为0010 和 0001 两数相加，没有进位，结果等于 1^2
 * 而当两个数有进位时就需要计算进位，比如3 3，进位的次数用&运算计算，
 * 3 & 3 等于3，
 * 0011 + 0011 计算结果为6，
 * 就二进制加法   从最低位开始 1 1加完为2，进位一次 ，接着1 1 加完再进位一次，最后的1再进位 得到 0110结果，总共进位三次
 */
public class AddAB {
    public static void main(String[] args) {
        System.out.println(add(1, 13));
    }

    public static int add(int a,int b) {
        while(b != 0) {
            int temp = a & b;
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }
}
