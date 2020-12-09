package day12_9;

/**
 * 饥饿的小易  todo： 待改
 */
public class hungryYi {
    public static void main(String[] args) {

    }

    public static int yi(int n) {
        int count = 0;
        while (n != 0 && count <= 30_000) {
            n = ((n << 1) + 1) % 1_000_000_007;
            count++;
        }

        int res = count % 3 == 0 ? count /3 : count / 3 + 1;
        return res > 100_000 ? -1 : res;
    }
}
