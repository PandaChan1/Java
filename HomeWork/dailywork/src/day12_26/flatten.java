package day12_26;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *@ClassName: flatten
 *@Description leetcode430-扁平化多级链表
 * 思路1：脖子左转45°，其实就是一个二叉树，输出其前序遍历链表
 * 思路2：同样脖子左转45°，二叉树深度优先搜索，输出前序
 *@Author PandaChan1
 *@Date 2020/12/26
 *@Time 17:26
 */

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node head, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = head;
        this.child = child;
    }
}

public class flatten {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node cur = head;

        while(cur != null) {
            if(cur.child != null) {
                Node next = cur.next;  //记录原来的next

                Node child = flatten(cur.child);


                cur.next = child;
                child.prev = cur;
                cur.child = null;

                if(next != null) {
                    while(cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    public Node flatten_dfs(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

}
