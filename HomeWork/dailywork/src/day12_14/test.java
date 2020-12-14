package day12_14;

import java.util.*;

public class test {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map  = new HashMap<>();

        for(int i = 0; i < strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list= map.getOrDefault(s,new ArrayList<String>());
            list.add(strs[i]);
            map.put(s,list);
        }
return new ArrayList<List<String>>(map.values());
    }

}
