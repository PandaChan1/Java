package day12_7;

public class square {
    public static void main(String[] args) {
        stringSquare(3,'a');
        System.out.println();
        System.out.println("aaaaaaaaaa\n" +
                "a a\n" +
                "a a\n" +
                "a a\n" +
                "aaaaaaaaaa");
    }



    public static void stringSquare(int n,char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        int row;
        if (n / 2 == 0) {
            row = n / 2;
        }else {
            row = n / 2 + 1;
        }
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                System.out.println(sb.toString());
            }else if (i == row - 1) {
                System.out.println(sb.toString());
            } else {
                System.out.print(c);
                for (int j = 1; j < n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print(c);
            }
        }
    }
}
