package day2_2;



import java.util.Scanner;

public class JavaMethodNameFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (i == 0) {
                    sb.append(c);
                    continue;
                }

                if (c != '_') {
                    if (str.charAt(i - 1) != '_') {
                        sb.append(c);
                    }else {
                        sb.append(Character.toUpperCase(c));
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
