package day12_12;

import java.util.Scanner;

/**
 * 找出基因序列中长度位n的最高比例的GC串
 */
public class gene {
    /**
     * 思路：循环该基因序列，找出GC比例最高的子串的开始位置即可
     */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String gene = scanner.nextLine();
                int n = scanner.nextInt();
                // 记录GC最大的数
                int max = 0, index = 0;
                for (int i = 0; i < gene.length() - n; i++) {
                    String sub = gene.substring(i, i + n);
                    int count = 0;
                    // 统计子串中的G/C的数量
                    for (Character ch : sub.toCharArray()) {
                        if (ch == 'G' || ch == 'C') {
                            count++;
                        }
                    }
                    // 若G/C的数量大，则记录此时子串的开始位置
                    if (count > max) {
                        max = count;
                        index = i;
                    }
                }
                System.out.println(gene.substring(index, index + n));
            }
        }
}
