package Code;

import Data.GroupOfNumber;

public class GroupOfOddEve {
    public static void main(String[] args) {
        int len = GroupOfNumber.GROUP_NUMBER.length;
        int end = len;
        int j = 0;
        int[] result = new int[len] ;
        for (int i = 0; i < len; i++) {
            //结果 5 11 5 7 9 9 7 11 22 2 6 8 54 22 8 2 6
            // & 运算符可以区分奇数与偶数
            //一个数的二进制位最后一位为 1 则说明该数是奇数，因此 (奇数 & 1) == 1 时说明该数为奇数
                if ((GroupOfNumber.GROUP_NUMBER[i] & 1) == 1) {
                    result[j] = GroupOfNumber.GROUP_NUMBER[i];
                    j++;
                }else {
                    end--;
                    result[end] = GroupOfNumber.GROUP_NUMBER[i];
                }

        }
        for (int i :
                result) {
            System.out.print(i+" ");
        }
    }

}
