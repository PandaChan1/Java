package Code;

import Data.GroupOfNumber;

public class GroupOfOddEve {
    public static void main(String[] args) {
        int len = GroupOfNumber.GROUP_NUMBER.length;
        int end = len;
        int j = 0;
        int[] result = new int[len] ;
        for (int i = 0; i < len; i++) {
                if (GroupOfNumber.GROUP_NUMBER[i] % 2 != 0) {
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
