package day12_27;
/**
 *@ClassName: sameStructString
 *@Description leetcode205-同构字符串  思路：A-B和B-A都存在唯一映射关系，说明同构
 *@Author PandaChan1
 *@Date 2020/12/27
 *@Time 19:50
 */


import java.util.HashMap;
import java.util.Map;

public class sameStructString {
    public boolean isIsomorphic(String s, String t) {
        return helper(s,t) && helper(t,s);
    }

    public boolean helper(String s,String t) {
        Map<Character,Character> maps = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(maps.containsKey(c1)) {
                if(maps.get(c1) != c2) {
                    return false;
                }
            }else {
                maps.put(c1,c2);
            }
        }
        return true;
    }
}
