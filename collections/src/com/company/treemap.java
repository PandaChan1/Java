package com.company;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class treemap {
    public static void main(String [] args){
//        Map<Peer,Integer> map=new TreeMap<>();
        Map<Peer,Integer> map=new TreeMap<>(new Comparator<Peer>() {

            @Override
            public int compare(Peer o1, Peer o2) {
                if (o1.score==o2.score){
                return 0;
                }
                return o1.score>o2.score ? 1:-1;
            }
        });
        map.put(new Peer("Tom", 77), 1);
        map.put(new Peer("Bob", 66), 2);
        map.put(new Peer("Lily", 99), 3);
        for (Peer p: map.keySet()){
            System.out.println(p);
        }
        System.out.println(map.get(new Peer("Bob",66)));
    }
}
class Peer {
    public String name;
    public int score;
    Peer(String name,int score){
        this.name=name;
        this.score=score;
    }
    public String toString(){
        return String.format("{%s:score=%d}",name,score);
    }

//    @Override
//    public int compareTo(Peer o) {
//        if (this.score>o.score){  //score升序排列
//            return 1;
//        }else if (this.score==o.score){
//            return 0;
//        }else{
//            return -1;
//        }
//    }
}
