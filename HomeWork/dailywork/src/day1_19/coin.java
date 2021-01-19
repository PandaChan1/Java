package day1_19;

import java.util.Scanner;

public class coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String p = sc.next();
            String a = sc.next();

            String[] ps = p.split("[.]");
            String[] as = a.split("[.]");

            StringBuilder sb = new StringBuilder();

           Long pay =  Long.parseLong(ps[0]) * 17 * 29 + Long.parseLong(ps[1]) * 29 + Long.parseLong(ps[2]);
           Long have = Long.parseLong(as[0]) * 17 * 29 + Long.parseLong(as[1]) * 29 + Long.parseLong(as[2]);
           long res = have - pay;

          if (res == 0) {
               System.out.println(0);
           }else{
              if (res < 0) {
                  sb.append("-");
                  res = -1 * res;
              }
              sb.append(res / (17 * 29))
                      .append(".")
                      .append(res % (17 * 29) / 29)
                      .append(".")
                      .append(res % (17 * 29) % 29);
              System.out.println(sb.toString());
          }

        }
    }
}
