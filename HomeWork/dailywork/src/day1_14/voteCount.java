package day1_14;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class voteCount {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                //该方法此处要用LinkedMap
                Map<String,Integer> map = new LinkedHashMap<>();
                for(int i = 0;i < num;i++){
                    String p = sc.next();
                    map.put(p,0);
                }
                map.put("Invalid",0);
                int t = sc.nextInt();

                for(int j = 0;j < t;j++){
                    String people = sc.next();
                    if(map.containsKey(people)){
                        map.put(people,map.get(people)+1);
                    } else{
                        map.put("Invalid",map.get("Invalid")+1);
                    }
                }
                for(Map.Entry<String,Integer> entry : map.entrySet()){
                    System.out.println(entry.getKey()+" : "+ entry.getValue());
                }
            }
        }
}
