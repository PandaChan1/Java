package LeetCode.滑动窗口;

import java.util.HashSet;

/**
 *@ClassName: longest_substring_length_withoutRepeat
 *@Description 无重复最长字串的长度
 *@Author PandaChan1
 *@Date 2021/3/5
 *@Time 15:14
 */

//滑动窗口
public class longest_substring_length_withoutRepeat {
    public static void main(String[] args) {
        solution("abcaabbacdab");
    }

    public static void solution(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = -1;  //最左边，但是不指向任何一个下标，所以未-1
        int ans = 0;  //最长的长度
        int n = s.length();
        int i;
        for( i = 0; i < n;i++) {

            if(i != 0) {
                //能进入这里，说明i > 0，且left + 1 位置和set中的字符重复了，那么我们就从set中移除一个字符，
                set.remove(s.charAt(i - 1));
            }

            //left + 1 说明开始从左到右滑动，找结束位置
            //遇到set中没有的就存储，那么set中就一直存的是无重复的字符串
            while(left + 1 < n && !set.contains(s.charAt(left + 1)) ) {
                set.add(s.charAt(left + 1));
                left++;
            }
            //跳出循环，说明遇到了一个重复的字符，此时left + 1下标的字符就是重复的字符
            //这时，算一下ans和当前无重复字符长度哪个大
            ans = Math.max(ans,left - i + 1);
        }
        System.out.println(ans);
    }
}
