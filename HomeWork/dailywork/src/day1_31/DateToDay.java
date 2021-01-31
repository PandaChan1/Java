package day1_31;

import java.util.Scanner;

/**
 *@ClassName: DateToDay
 *@Description 日期转换该年的第几天
 *@Author PandaChan1
 *@Date 2021/1/31
 *@Time 17:47
 */

//四年一闰，百年不闰（被4整除，不能被100整除的是闰年；能被400整除是闰年）
public class DateToDay {
    private int leapMonth[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int normalMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int result;

    public int iConverDateToDay(int year, int month, int day) {
        if (year <= 0 || month <= 0 || month > 12 || day <= 0) {
            return result = -1;
        }

        boolean isLeapYear = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            isLeapYear = true;
        }
        if (isLeapYear && day > leapMonth[month]) {
            return result = -1;
        }
        if (!isLeapYear && day > normalMonth[month]) {
            return result = -1;
        }
        result = 0;
        for (int i = 1; i < month; i++) {
            if (isLeapYear) {
                result += leapMonth[i];
            } else {
                result += normalMonth[i];
            }
        }
        result += day;
        return 0;
    }

    public int getOutDay() {
        return result;
    }

    public static void main(String[] args) {
        DateToDay solution = new DateToDay();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int year = in.nextInt(), month = in.nextInt(), day = in.nextInt();
            solution.iConverDateToDay(year, month, day);
            int result = solution.getOutDay();
            System.out.println(result);
        }
    }

}



