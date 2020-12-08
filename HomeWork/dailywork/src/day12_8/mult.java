package day12_8;

/**
 * 尼彻斯特定理
 */
public class mult {
    public static void main(String[] args) {
        show(3);
    }
    public static void show(int n) {
        StringBuilder sb = new StringBuilder();
        int cur = n * n - n + 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sb.append(cur);
            }else {
                sb.append("+" + cur);
            }
            cur += 2;
        }
        System.out.println(sb.toString());
    }
}
