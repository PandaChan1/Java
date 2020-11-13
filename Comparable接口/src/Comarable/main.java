package Comarable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class main {
    public static  void main(String[] args){
        ArrayList<student> list=new ArrayList<>();
        list.add(new student("赵","man",16,136));
        list.add(new student("钱","women",22,188));
        list.add(new student("孙","woman",62,177));
        list.add(new student("李","woman",21,158));
        System.out.println(list.toString());
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
        //System.out.println(list.toString());
    }
}
