package HashBuck;

class BolgHashBuck{
    static class Buck {
        public int key;
        public int val;
        public Buck next;

        public Buck(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

        public Buck[] array;
        public int usedsize;
        public BolgHashBuck() {
        this.array = new Buck[10];
        this.usedsize = 0;
        }

        //插入
        public void put(int key,int val) {
        Buck buck = new Buck(key,val);
        int index = key % this.array.length;
        //先找一遍，有没有同样key的元素，有就替换
        for (Buck cur = this.array[index]; cur != null;cur = cur.next) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
        }
        //头插
            buck.next = this.array[index];
            this.array[index] = buck;
            this.usedsize++;
            //大于负载因子时扩容
            if (loadFactor() > 0.75) {
                resize();
            }

        }

        //扩容，重新哈希
        public void resize() {
        Buck[] newArray = new Buck[this.array.length * 2];
            for (int i = 0; i < this.array.length; i++) {
                Buck curNext = null;
                for (Buck cur = this.array[i]; cur != null;cur = curNext) {
                    curNext = cur.next;

                    int index = cur.key % newArray.length;
                    cur.next = newArray[index];
                    newArray[index] = cur;

                }
            }
            this.array = newArray;
        }

        //获取key的值
        public int getValue(int key) {
        int index = key % this.array.length;
        for(Buck cur = this.array[index];cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.val;
            }
        }
        return -1;
        }

        //负载因子
    public float loadFactor() {
            return this.usedsize * 1.0f / this.array.length;
    }
    }

public class MyBlogHashBuck {
    public static void main(String[] args) {
        BolgHashBuck bolgHashBuck = new BolgHashBuck();
        bolgHashBuck.put(1,20);
        bolgHashBuck.put(11,111);
        bolgHashBuck.put(2,22);
        bolgHashBuck.put(3,3);
        bolgHashBuck.put(4,4);
        bolgHashBuck.put(5,5);
        bolgHashBuck.put(6,6);
        bolgHashBuck.put(7,7);
        bolgHashBuck.put(8,8);
        bolgHashBuck.put(9,9);
        bolgHashBuck.put(0,9);
        bolgHashBuck.put(21,999);
        System.out.println("dadadadawdada");
    }
}
