package Code;

/**
 *
 * 输出1-100之间的素数
 */
public class primeNum {
    public static void main(String[] args) {
    for (int i = 1;i <= 100;i++) {
        int count=0;
        for (int j = 2;j < i;j++) {
            if (0 == i % j) {
                count++;
            }
        }
            if (count == 0) {
                 System.out.println(i+" 是素数");
            }
         }
    }
}
