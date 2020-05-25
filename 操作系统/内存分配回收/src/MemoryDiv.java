
import java.util.*;

public class MemoryDiv{
    private int msize; //内存大小
    private static final int min_size=5;//最小内存大小
    private LinkedList<tab> tabs;//双向链表
    private  int pointer;//上次分配的空闲区位置
    private static Scanner sc;
    class tab{
        private int size; //分区大小
        private int head;//分区始址
        private boolean free;//分区状态
        public tab(int size,int head){
            this.head=head;
            this.size=size;
            this.free=true;
        }
    }
    public static class SortByHead implements Comparator<tab>{

        @Override
        public int compare(tab o1, tab o2) {
            return o1.head-o2.head;  //起始地址升序排列
        }
    }
    public static class SortBySize implements Comparator<tab>{

        @Override
        public int compare(tab o1, tab o2) {
            return o2.size-o1.size; //空闲分区大小降序
        }
    }
    public static class SortBySizeDes implements  Comparator<tab>{

        @Override
        public int compare(tab o1, tab o2) {
            return o1.size-o2.size; //空闲分区升序
        }
    }
    public MemoryDiv(){  //设置内存大小
        this.msize=100;
        this.pointer=0;
        this.tabs=new LinkedList<>();
        tabs.add(new tab(msize,0));
    }
    public MemoryDiv(int msize){  //设置内存大小
        this.msize=msize;
        this.pointer=0;
        this.tabs=new LinkedList<>();
        tabs.add(new tab(msize,0));
    }
    public void allocation(int size){
        System.out.println("1.首次适应算法 2.循环首次适应算法 3.最佳适应算法 4.最坏适应算法");
        System.out.print("请选择分配算法:");
        //Scanner in = new Scanner(System.in);
        int alg = sc.nextInt();
        switch (alg){
            case 1:
                FF(size);break;
            case 2:
                NF(size);break;
            case 3:
                BF(size);break;
            case 4:
                WF(size);break;
            default:
                System.out.println("请重新选择!");
        }
    }
    public void init(){  //初始化内存分区情况
        System.out.println("输入分区个数!");
        tabs.clear();
        sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println("分别输入"+num+"个分区的大小!");
        for (int i=0;i<num;i++){
            int algsize=sc.nextInt();
            if (i==0) {
                tabs.add(new tab(algsize, 0));
            }else{
                tabs.add(new tab(algsize,tabs.get(i-1).head+tabs.get(i-1).size));
            }
        }
    }
    private void FF(int size){ //首次适应算法
        Collections.sort(tabs,new SortByHead());
        for (pointer=0;pointer<tabs.size();pointer++){
            tab temp=tabs.get(pointer);
            if (temp.free&&(temp.size>=size)){
                doi(size,pointer,temp);
                break;
            }
        }
    }
    private void NF(int size){ //循环首次适应算法
        tab temp=tabs.get(pointer);
        if (temp.free&&(temp.size>=size)){
            doi(size,pointer,temp);
            return;
        }else{
            int len=tabs.size();
            int i=(pointer+1)%len;
            for (;i!=pointer;i=(i+1)%len){
                temp=tabs.get(i);
                if (temp.free&&(temp.size>size)){
                    doi(size,i,temp);
                    return;
                }
            }
        }
        System.out.println("无可用内存空间");
    }
    private void BF(int size){ //最佳适应算法
        Collections.sort(tabs,new SortBySizeDes());
        int flag=-1;
        int min=this.msize;
        for (pointer=0;pointer<tabs.size();pointer++){
            tab temp=tabs.get(pointer);
            if (temp.free&&(temp.size>=size)){
                if (min>temp.size-size){
                    min=temp.size-size;
                    flag=pointer;
                }
            }
        }
        if (flag==-1){
            System.out.println("无可用内存空间");
        }else{
            doi(size,flag,tabs.get(flag));
        }
    }
    private void WF(int size){ //最坏适应算法
        Collections.sort(tabs,new SortBySize());
        int flag=-1;
        int max=0;
        for (pointer=0;pointer<tabs.size();pointer++){
            tab temp=tabs.get(pointer);
            if (temp.free && (temp.size >=size)) {
                if (max<temp.size-size){
                    max=temp.size-size;
                    flag=pointer;
                }
            }
        }
        if (flag==-1){
            System.out.println("无可用内存空间");
        }else{
            doi(size,flag,tabs.get(flag));
        }
    }

    private void doi(int size,int location,tab temp){ //分配
        if (temp.size-size<=min_size){
            temp.free=false;
        }else{
            tab split=new tab(temp.size-size,temp.head+size);
            tabs.add(location+1,split);
            temp.size=size;
            temp.free=false;
        }
        System.out.println("成功分配"+size+"内存");
    }
    public void collection(int id){
        if(id>=tabs.size()){
            System.out.println("无此分区编号");
            return;
        }
        tab temp=tabs.get(id);
        int size=temp.size;
        if (temp.free){
            System.out.println("指定分区未被分配，无需回收");
            return;
        }
        if (id<tabs.size()-1&&tabs.get(id+1).free){
            tab next=tabs.get(id+1);
            temp.size+=next.size;
            tabs.remove(next);
        }
        if (id>0&&tabs.get(id-1).free){
            tab previous=tabs.get(id-1);
            previous.size+=temp.size;
            tabs.remove(id);
            id--;
        }
        tabs.get(id).free=true;
        System.out.println("内存成功回收");
    }
    public void show(){
        System.out.println("-----------------");
        System.out.println("分区编号\t分区始址\t分区大小\t空闲状态\t");
        System.out.println("------------------");
        for (int i=0;i<tabs.size();i++){
            tab temp=tabs.get(i);
            System.out.println(i + "\t\t" + temp.head + "\t\t" +
                    temp.size + "  \t" + temp.free);
        }
        System.out.println("--------------------");
    }
    public int diao(){
        System.out.println("输入要分配的内存大小");
        int dv=sc.nextInt();
        return dv;
    }
    public static void main(String[] args){
        int j;
        boolean contin=true;
        String n;
        MemoryDiv md=new MemoryDiv();
        md.show();
        md.init();
        md.show();
        while (contin){
            j = md.diao() ;
            md.allocation(j);
            md.show();
            System.out.println("是否继续进行分配?输入ture或false");
            contin=sc.nextBoolean();
        }
        System.out.println("是否进行内存回收操作");
        n=sc.next();
        switch (n){
            case"yes":
            {System.out.println("输入要回收的分区号");
                int id=sc.nextInt();
                md.collection(id);
                md.show();break;}
            case"no":break;
        }
    }
}