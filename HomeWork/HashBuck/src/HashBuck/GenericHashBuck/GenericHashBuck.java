package HashBuck.GenericHashBuck;

import java.util.Objects;

class Person{
    public int id;
    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


class HashBuck<K,V>{
    static class Node<K,V>{
        public K key;
        public V val;
        public Node<K,V> next;
        public Node(K key,V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array;
    public int usedsize;
    public HashBuck(){
        this.array =  new Node[10];
        this.usedsize = 0;
    }


    /**
     * 自定义类型需要重写HashCode和equals方法
     * HashCode：为了找到位置
     * equals：为了比较key是否相同
     * @param key
     * @param val
     */
    //插入
    public void put (K key,V val) {
        int hash = key.hashCode();
        int index = hash % this.array.length;
        //遍历这个位置下方的链表
        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        //该链表中没有和key值一样的元素，头插
        Node<K,V> node = new Node<K,V>(key,val);
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
        Node<K,V>[] newArray = new Node[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            Node<K,V> curNext = null;
            for (Node<K,V> cur = this.array[i]; cur != null; cur = curNext) {
                curNext = cur.next;
                //array[i] 下有链表
                int hash = cur.hashCode();
                int index = hash % this.array.length;
                cur.next = newArray[index].next;
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }

    public V getValue(K key) {
           int hash = key.hashCode();
           int index = hash % this.array.length;
            for (Node<K,V> cur = this.array[index]; cur != null; cur = cur.next) {
                if (key.equals(cur.key)) {
                    return (V) cur.val;
                }
            }
        return null;
    }

    //计算负载因子
    private float loadFactor() {
        return this.usedsize * 1.0f / this.array.length;
    }

}

public class GenericHashBuck {
    public static void main(String[] args) {
        Person person1 = new Person(6122);
        Person person2 = new Person(6125);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        HashBuck<Person,String> buck1 = new HashBuck<>();
        buck1.put(person1,"陈");
        buck1.put(person2,"王");
        System.out.println("sdajkdjakda");
    }
}
