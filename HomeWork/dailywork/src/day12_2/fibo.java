package day12_2;

public class fibo {
    public static void main(String[] args) {
    fibonacci(15);
    }

    public static void fibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        int f3;

        while(f2 < n) {
            f3 = f1 + f2;
            f1 = f2;
            f2 =f3;
        }

        int ans = Math.min(Math.abs(f1 - n),Math.abs(f2 - n));
        System.out.println(ans);

//        for (int i = col; i < y; ) {
//            i++;
//            dfs(row,i);
//            i--;
//            for (int j = row; j < x;) {
//                j++;
//                dfs(j,col);
////                j--;
//            }
//           i--;
//        }
    }
}
