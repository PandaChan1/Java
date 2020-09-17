package Alg;

public class greedyAlg {
    public static int[] greedy(int[] start,int[] end){
        int total=start.length;
        int endtime=end[0];
        int[] arrangement=new int[total];
        arrangement[0]=1;
        int count=1;
        for(int i=0;i<total;i++){
            if (start[i]>endtime){
                arrangement[count++]=i+1;
                endtime=end[i];
            }
        }
        return arrangement;
    }
}
