package MyGenericList.MyGenericArrayList;

import java.util.Arrays;

/**
 *@ClassName: MyArrayList
 *@Description arrayList复习
 *@Author PandaChan1
 *@Date 2020/11/20
 *@Time 16:05
 */


public class GenericArrayList<T> {
    public T[] elem;
    public int usedsize;
    public GenericArrayList() {
        this.elem = (T[]) new Object[10];
        this.usedsize = 0;
    }
    public GenericArrayList(int cap) {
        this.elem = (T[])new Object[cap];
        this.usedsize = 0;
    }

    //插入
    public void add(T val) {
        if (isFull()) {
            resize();
        }
    this.elem[this.usedsize++] = val;
    }
    public void add(int index,T val) {
    if (isFull()) {
        resize();
    }
    if (index < 0 || index > this.usedsize) {
        return;
    }
        for (int i = this.usedsize; i >  index; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[index] = val;
        this.usedsize++;
    }
    //删除第一次遇到的元素
    private int findindex(T key) {
        if (!contains(key)) {
            return -1;
        }
        for (int i = 0; i < this.usedsize; i++) {
            if ( key.equals(this.elem[i])) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T key) {
    if (isEmpty()) {  //为空返回
        return;
    }
    int find = findindex(key);  //找到要删除的key的第一个下标
    if (find == -1) {  //不存在key
        return;
    }
    if (find == this.usedsize - 1) {  //如果要删除的是最后一个
        this.usedsize--;
        return;
    }
    //删除的不是最后一个
        for (int i = find; i < this.usedsize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
       this.usedsize--;
    }
    //删除遇到的所有关键字
    public void removeAll(T key) {
    if (isEmpty()) {
        return;
    }
    while (contains(key)) {
        remove(key);
    }
    }
    //扩容
    public void resize() {
    if (isFull()) {
     this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
    }
    }
    //判断是否包含某个元素
    public boolean contains(T key) {
    if (isEmpty()) {
        return false;
    }
        for (int i = 0; i < this.usedsize; i++) {
            if (key.equals(this.elem[i] )) {   //判断值相等，需要重写equals
                return true;
            }
        }
        return false;
    }
    //清空
    public void clear() {
    this.usedsize = 0;
    }
    //返回指定下标的元素
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > this.usedsize) {
            return null;
        }
        return this.elem[index];
    }

    //判空
    public boolean isEmpty() {
        if (this.usedsize == 0) {
            return true;
        }
        return false;
    }
    //判满
    public boolean isFull() {
        if (this.elem.length == this.usedsize) {
            return true;
        }
        return false;
    }
    //显示
    public void display() {
        for (int i = 0; i < this.usedsize; i++) {
            System.out.print(this.elem[i] + "  ");
        }
        System.out.println();
    }

}
