package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/2
 **/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode p = head;
        ListNode q = head.next;
        do {
            // 交换p,q
            ListNode n = q.next;
            q.next = p;
            p.next = n;
            if (newHead == null) {
                newHead = q;
            }
            if (newTail == null) {
                newTail = p;
            } else {
                newTail.next = q;
                newTail = p;
            }
            if (n == null||n.next == null) {
                break;
            }  else {
                p = n;
                q = n.next;
            }

        } while (true);

        return newHead;
    }
}
