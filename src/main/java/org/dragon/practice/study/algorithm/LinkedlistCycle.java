package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/2
 **/
public class LinkedlistCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p = head;
        ListNode q = head;
        p = p.next;
        q = q.next.next;

        while (p != null && q != null && q.next != null) {
            if (p == q) {
                return true;
            }
            p = p.next;
            q = q.next.next;

        }
        return false;

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode p = head;
        ListNode q = head;
        p = p.next;
        q = q.next.next;

        while (p != null && q != null && q.next != null) {
            if (p == q) {
                // 有环，检测入口点，p继续走，新建s从head走，一定相遇，相遇的点就是入口点
                ListNode s = head;
                while (s != p) {
                    s = s.next;
                    p = p.next;
                }
                return s;
            }
            p = p.next;
            q = q.next.next;

        }
        return null;
    }
}
