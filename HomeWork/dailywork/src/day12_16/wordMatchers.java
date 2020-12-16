package day12_16;

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName: test
 *@Description 单词匹配，使用map存储两次映射关系，两个关系都返回true说明匹配成功；同构字符串也采用该方法
 *@Author PandaChan1
 *@Date 2020/12/16
 *@Time 14:55
 */


public class wordMatchers {
    public static void main(String[] args) {
        wordMatchers t = new wordMatchers();
        System.out.println(t.wordPattern("abba", "dog cat cat dog"));
    }


    public boolean wordPattern(String pattern, String s) {
        if(s == null || pattern == null) return false;

        if(s.length() == 0 || pattern.length() == 0) return false;

        String[] splits = s.split(" ");

        if(splits.length != pattern.length() ) return false;

        return helper(pattern,splits) && helper(splits,pattern);  //两次映射，都为true说明匹配成功
    }


    public boolean helper(String[] strs,String str) {
        Map<String,Character> maps = new HashMap<>();

        for(int i = 0; i < strs.length;i++) {
            char c = str.charAt(i);
            String s = strs[i];
            if(maps.containsKey(s)) {
                if(maps.get(s) != c) {
                    return false;
                }
            }else {
                maps.put(s,c);
            }
        }
        return true;
    }

    public boolean helper(String str, String[] strs) {
        Map<Character,String> maps = new HashMap<>();

        for(int i = 0; i < strs.length;i++) {
            char c = str.charAt(i);
            String s = strs[i];
            if(maps.containsKey(c)) {
                if(!s.equals(maps.get(c))) {
                    return false;
                }
            }else {
                maps.put(c,s);
            }
        }
        return true;
    }
}
