package day11_29;

public class minBeishu {
    public static void main(String[] args) {
        minB(4,7);
    }

    public static void minB(int x,int y) {
        int mult = x * y;
    if(x < y) {
        int temp = x;
        x = y;
        y = temp;
    }

    while(true) {
        int temp = x % y;
        if (temp == 0) {
            System.out.println(mult / y);
            break;
        } else {
            x = y;
            y = temp;
        }
    }

    }

}
