package day2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *@ClassName: phoneNumber
 *@Description 电话号码  https://www.nowcoder.com/questionTerminal/ceb89f19187b4de3997d9cdef2d551e8
 *@Author PandaChan1
 *@Date 2021/2/3
 *@Time 17:34
 */


public class phoneNumber {
        public static void main(String[] args){
            String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            String number="222333444555666777788899991234567890";
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                int n=scanner.nextInt();
                ArrayList<String> arrayList=new ArrayList<String>();
                for(int i=0;i<n;i++){
                    String str=scanner.next();
                    str=str.replace("-","");
                    String result="";
                    for(int j=0;j<7;j++){
                        result+=number.charAt(symbol.indexOf(str.charAt(j)+""));
                    }
                    result=result.substring(0,3)+"-"+result.substring(3,7);
                    if(!arrayList.contains(result))
                        arrayList.add(result);
                }
                Collections.sort(arrayList);
                for(int j=0;j<arrayList.size();j++){
                    System.out.println(arrayList.get(j));
                }
                System.out.println();
            }
        }

}