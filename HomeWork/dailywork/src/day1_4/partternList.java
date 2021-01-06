package day1_4;

/**
 *@ClassName: ListNode
 *@Description 分割链表  思路：分成两部分，大于x的和小于x的，然后拼接即可
 *@Author PandaChan1
 *@Date 2021/1/6
 *@Time 19:25
 */


class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int n) {
        this.val = n;
    }
}

public class partternList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
