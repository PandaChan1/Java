package day2_4;

import java.util.Scanner;

/**
 *@ClassName: StringContains
 *@Description 乒乓球筐 牛客 https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32?orderByHotValue=0&pos=103&mutiTagIds=589
 *@Author PandaChan1
 *@Date 2021/2/5
 *@Time 18:47
 */

/**
 * nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类
 * 并且每种球的数量不少于B盒中的数量，该怎么办呢？
 *
 * ABCDFYE CDE
 * ABCDGEAS CDECDE
 *
 * 输出
 *
 * Yes
 * No
 */

public class StringContains {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            boolean contain = true;
            StringBuilder input = new StringBuilder(in.next());
            char[] find = in.next().toCharArray();
            for (char c : find)
            {
                int index = input.indexOf(String.valueOf(c));
                if (index != -1)
                    input.deleteCharAt(index);
                else
                {
                    System.out.println("No");
                    contain = false;
                    break;
                }
            }
            if (contain)
                System.out.println("Yes");
        }
    }
}
