import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Input {
    public static void calculate(pcb[] pcbs){  //计算
        int end1=pcbs[0].getIntime()+pcbs[0].getServ();
        pcbs[0].setEnd(end1);
        for (int i=1;i<pcbs.length;i++){ //完成时间
            pcbs[i].setEnd(pcbs[i-1].getEnd()+pcbs[i].getServ());
        }
        for (int i=0;i<pcbs.length;i++){   //周转时间
            pcbs[i].setRun(pcbs[i].getEnd()-pcbs[i].getIntime()); //周转时间=完成时间-进入时间
        }
        for (int i=0;i<pcbs.length;i++){ //带权周转时间
            pcbs[i].setWrun((double)(pcbs[i].getRun()/pcbs[i].getServ())); //带权周转时间=周转时间/服务时间
        }

        System.out.println("标识符  进入时间  服务时间  优先级  完成时间  周转时间 带权周转时间");
        for (int i=0;i<pcbs.length;i++){
            System.out.print(pcbs[i].getTag());
            System.out.print("        ");
            System.out.print(pcbs[i].getIntime());
            System.out.print("        ");
            System.out.print(pcbs[i].getServ());
            System.out.print("        ");
            System.out.print(pcbs[i].getPrio());
            System.out.print("        ");
            System.out.print(pcbs[i].getEnd());
            System.out.print("        ");
            System.out.print(pcbs[i].getRun());
            System.out.print("        ");
            System.out.println(pcbs[i].getWrun());
        }
    }
    public static void FCFS(pcb[] pcbs, int q){ //先来先服务
        Arrays.sort(pcbs,new pcb.sortbyIntime());
        calculate(pcbs);
    }
    public static void PSA(pcb[] pcbs,int q){ //优先级优先
        Arrays.sort(pcbs,new pcb.sortbyPrio());
        calculate(pcbs);

    }
    public static void RR(pcb[] pcbs,int q){ //时间片轮转
        Arrays.sort(pcbs,new pcb.sortbyIntime());  //进入时间排序
        Queue<pcb> que=new LinkedList<pcb>();
        int count=0;
        int sumtime=pcbs[0].getIntime();
        for (int i=0;i<pcbs.length;i++){ //初始化剩余时间
            pcbs[i].setSheng(pcbs[i].getServ());
        }
        que.offer(pcbs[0]);
        while(count<pcbs.length) {
            pcb a = que.poll();
            if (a.getSheng()>q){
                sumtime=sumtime+q;
                a.setSheng(a.getSheng()-q);
            }else if (a.getSheng()<=q){
                sumtime=sumtime+a.getSheng();
                a.setOk(true);
                a.setEnd(sumtime);
                count++;
            }
            for (int i=0;i<pcbs.length;i++){
                if (pcbs[i].getIntime()<=sumtime&&pcbs[i]!=a&&!que.contains(pcbs[i])&&!pcbs[i].isOk()){
                    que.offer(pcbs[i]);
                }
            }
            if (!a.isOk()){
                que.offer(a);
            }
        }
        for (int i=0;i<pcbs.length;i++){ //周转时间
            pcbs[i].setRun(pcbs[i].getEnd()-pcbs[i].getIntime());
        }
        for (int i=0;i<pcbs.length;i++){ //带权周转时间
            pcbs[i].setWrun((double) (pcbs[i].getRun()/pcbs[i].getServ()));
        }
        System.out.println("标识符  进入时间  服务时间  优先级  完成时间  周转时间 带权周转时间");
        for (int i=0;i<pcbs.length;i++){
            System.out.print(pcbs[i].getTag());
            System.out.print("        ");
            System.out.print(pcbs[i].getIntime());
            System.out.print("        ");
            System.out.print(pcbs[i].getServ());
            System.out.print("        ");
            System.out.print(pcbs[i].getPrio());
            System.out.print("        ");
            System.out.print(pcbs[i].getEnd());
            System.out.print("        ");
            System.out.print(pcbs[i].getRun());
            System.out.print("        ");
            System.out.println(pcbs[i].getWrun());
        }
    }

    public static void SJF(pcb[] pcbs,int q){  //短作业优先
        Arrays.sort(pcbs,new pcb.shortbyServ());
        calculate(pcbs);

    }

    public static void main(String[] args){
        int num=0;
        int timel=0;
        System.out.println("请输入进程个数和时间片长短：");
        Scanner s=new Scanner(System.in);
        num=s.nextInt();
        timel=s.nextInt();
        pcb[] pcbs_all=new pcb[num];
        System.out.println("依次输入进程标识符，进入时间，服务时间，优先级");
        for (int i=0;i<num;i++){
            pcb p=new pcb();
            p.setTag(s.next());
            p.setIntime(s.nextInt());
            p.setServ(s.nextInt());
            p.setPrio(s.nextInt());
            pcbs_all[i]=p;
        }

        System.out.println("标识符  进入时间  服务时间  优先级");
        for(int j=0;j<pcbs_all.length;j++){
            System.out.print(pcbs_all[j].getTag());
            System.out.print("        ");
            System.out.print(pcbs_all[j].getIntime());
            System.out.print("        ");
            System.out.print(pcbs_all[j].getServ());
            System.out.print("        ");
            System.out.println(pcbs_all[j].getPrio());
        }
        System.out.println("输出进程个数和时间片长短");
        System.out.print(num);
        System.out.print("   ");
        System.out.println(timel);
        System.out.println("选择算法1.先来先服务 2.优先级调度 3.短作业优先  4.时间片轮转");
        int ss=s.nextInt();
        switch(ss){
            case 1:FCFS(pcbs_all,num);break;
            case 2:PSA(pcbs_all,num);break;
            case 3:SJF(pcbs_all,num);break;
            case 4:RR(pcbs_all,timel);break;
        }
        s.close();
    }
}
