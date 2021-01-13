package day1_13;

/**
 *@ClassName: ToRMB
 *@Description 数字转人民币大写
 *@Author PandaChan1
 *@Date 2021/1/13
 *@Time 17:12
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;


    public class ToRMB{
        //一道需要反复斟酌边界条件的问题，
        static final String[] model= { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾" };
        public static void main(String[] args)throws Exception{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String str=null;
            while((str=reader.readLine())!=null){
                String[] s=str.split("\\.");
                int n=Integer.valueOf(s[0]);
                int m=0;
                if(s.length==2){
                    m =Integer.valueOf(s[1]);
                }
                StringBuilder res=new StringBuilder();
                int yi=n/100000000;
                if((yi)!=0){
                    res.append(get(yi)).append("亿");
                }
                StringBuilder temp1=res;
                n=n%100000000;
                int wan=n/10000;
                if((wan)!=0){
                    res.append(get(wan)).append("万");
                }
                n=n%10000;
                int qian=n;
                res.append(get(qian));
                if(res.charAt(0)=='零'){
                    res.deleteCharAt(0);
                }
                StringBuilder res1=new StringBuilder();
                res1.append("人民币").append(res);
                if(m==0){
                    res1.append("元整");
                }else{
                    if(n!=0){
                        res1.append("元");
                    }
                    if((m/10)!=0){
                        res1.append(model[m/10]).append("角");
                    }

                    if((m%10)!=0){
                        res1.append(model[m%10]).append("分");
                    }
                }
                System.out.println(res1);
            }
        }
        public static String get(int n){
            StringBuilder res=new StringBuilder();
            //处理千位上的数
            int qian=n/1000;//千位上的数是多少
            if((qian)!=0){
                res.append(model[Integer.valueOf(qian)]).append("仟");
            }
            else{
                res.append(model[0]);
            }
            //处理百位上的数
            n=n%1000;//n变为了n去掉千位后的数
            int bai=n/100;
            if((bai)!=0){
                res.append(model[Integer.valueOf(bai)]).append("佰");
            }else if(bai==0&&qian==0){
                //如果百位上是0 千位上也是0 那么什么也不做；
            }else if(bai==0&&qian!=0){
                //如果百位上是0，千位上不是零，那么此时要加零
                res.append(model[0]);
            }
            //处理十位上的数
            n=n%100;
            int shi=n/10;
            if(shi!=0){
                if(shi!=1){
                    res.append(model[shi]).append("拾");
                }else{
                    res.append("拾");
                }
            }else if(shi==0&&bai==0){
                //百位上是0 十位上也是0 那么什么也不做
            }else if(shi==0&&bai!=0){
                res.append(model[0]);
            }
            n=n%10;
            int ge=n;
            if(ge!=0){
                res.append(model[ge]);
            }

            return res.toString();


        }
    }
