package day1_15;

import java.util.Scanner;

/**
 *@ClassName: IPtransfrom
 *@Description ip地址和长整型转换，使用位运算
 *@Author PandaChan1
 *@Date 2021/1/15
 *@Time 18:39
 */


public class IPtransfrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.next();
            long ip = sc.nextLong();
            System.out.println(ipToLong(str));
            System.out.println(LongToip(ip));
        }
    }

    public static long ipToLong(String ipString){
        long ip = 0;
        String[] split = ipString.split("[.]");
            ip += Long.parseLong(split[0])<<24;
            ip += Long.parseLong(split[1])<<16;
            ip += Long.parseLong(split[2])<<8;
            ip += Long.parseLong(split[3]);
        return ip;
    }


    public static String LongToip(long ip) {
    StringBuilder sb  = new StringBuilder();
    sb.append(ip >>> 24);
    sb.append(".");
    sb.append((ip&0x00FFFFFF) >>> 16);
    sb.append(".");
    sb.append((ip&0x0000FFFF) >>> 8);
    sb.append(".");
    sb.append(ip&0x000000FF);
    return sb.toString();
    }
}
