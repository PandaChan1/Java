package HashBuck;

/**
 *@ClassName: MyHashBuck
 *@Description 实现哈希表
 *@Author PandaChan1
 *@Date 2020/11/19
 *@Time 10:44
 */

class HashBuck{
    static class Node{
        public int key;
        public int val;
        public Node next;
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedsize;
    public HashBuck(){
        this.array = new Node[10];
        this.usedsize = 0;
    }


    //插入
    public void put (int key,int val) {
        //位置
        int index = key % this.array.length;

        //遍历这个位置下方的链表
        for (Node cur = array[index];cur != null;cur = cur.next) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        //该链表中没有和key值一样的元素，头插
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedsize++;

        if (loadFactor() > 0.75) {
            resize();
        }
    }

    /**
     * 必须重新哈希
     */
    private void resize() {
        Node[] newArray = new Node[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            Node curNext = null;
            for (Node cur = this.array[i];cur != null;cur = curNext) {
                curNext = cur.next;
                //array[i] 下有链表
                int index = cur.key % newArray.length;
                cur.next = newArray[index].next;
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }

    public int getValue(int key) {
       int index = key % this.array.length;
            for (Node cur = this.array[index];cur != null;cur = cur.next) {
                if (cur.key == key) {
                    return cur.val;
                }
            }
        return -1;
    }

    //计算负载因子
    private float loadFactor() {
        return this.usedsize * 1.0f / this.array.length;
    }

}
public class MyHashBuck {


}
