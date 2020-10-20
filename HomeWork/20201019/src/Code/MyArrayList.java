package Code;

import java.util.Arrays;

/**
 *@ClassName: MyArrayList
 *@Description 实现ArrayList顺序表结构
 *@Author PandaChan1
 *@Date 2020/10/19
 *@Time 20:43
 */


public class MyArrayList {
    public int[] elem;
    public int usedSize = 0;  //elem[]中可用的元素个数

    //构造函数
    public MyArrayList() {
        this.elem = new int[5];
        this.usedSize = 0;
    }

    public MyArrayList(int capacity){
        this.elem = new int[capacity];
        this.usedSize = 0;
    }

    //在pos位置添加元素，从后往前插，插入的位置有元素则需要移位
    public void add(int pos,int data) {
        //顺序表插入时，插入位置前一个不能为空；即
        //pos不能为负数
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        //elem[]存满的时候，不能再插入
        if (isFull()) {
            //System.out.println("顺序表满了");
            reSize();
//            return;
        }
        //向后移
        for (int i = this.usedSize; i > pos ; i--) { //i > pos ，因为当i在pos+1时，已经将pos的值后移了
                this.elem[i] = this.elem[i - 1]; //后移
        }
        this.elem[pos] = data;
        this.usedSize++; //每次成功插入一个元素都要++
    }

    //判断顺序表是否存满
    public boolean isFull() {
        if (this.elem.length == this.usedSize) {
            return true;
        }else {
            return false;
        }
    }


    //顺序表扩容
    public void reSize() {
        if (isFull()) {
//            int[] copy = new int[this.elem.length * 2];
//            System.arraycopy(this.elem,0,copy,0,this.usedSize);
//            this.elem = copy;
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }else {
            return;
        }
    }

    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            if (i != this.usedSize - 1) {
                System.out.print(this.elem[i] + ", ");
            }else {
                System.out.println(this.elem[i] + " ");
            }
        }
    }

    //查询顺序表中是否包含某一元素
    public boolean contains(int data) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == data) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取该位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }

    //获取顺序表的大小
    public int size() {
        return this.usedSize;
    }

    //设置pos位置的元素值
    public void setElem(int pos,int value) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        this.elem[pos] = value;
    }

    //删除找到的第一个元素
    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1) {
            System.out.println("没有这个数字");
            return;
        }
        if (index >= 0) {
            for (int i = index; i < this.usedSize - 1; i++) {
                this.elem[i] = this.elem[i + 1];
            }
            this.usedSize--;
        }
    }

    //删除顺序表中所有的该元素
    public void removeAll(int toRemove) {
      /*  for (int i = 0; i < this.usedSize; i++) {
            if (this.contains(toRemove)) {
                remove(toRemove);
            }
        }*/
        while(this.contains(toRemove)) {
            remove(toRemove);
        }
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
