package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * 以k为分组翻转单链表
 *
 * @Author: Liuwl
 * Date: 2020/6/2
 **/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            if (count % k == 0) {
                head = reverseBetween(head, 1 + k * count / k, 1 + k + k * count / k);
            }
            p = p.next;
        }

        return head;

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = null;
        ListNode tempTail = null;
        ListNode tempHead = null;

        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            if (count == m - 1) {
                //记录断开的节点
                tempTail = p;
                p = p.next;
            } else if (count >= m && count <= n) {
                // 翻转
                // 保存之后的
                ListNode node = p.next;
                // 指向翻转后最前一个节点
                p.next = newHead;
                // 更新翻转后最前一个节点
                newHead = p;
                if (count == m) {
                    // 记录开始翻转的节点
                    tempHead = p;
                }
                if (count == n) {
                    // 最后一个需要翻转的节点。next连接到新的头节点上
                    if (tempTail != null)
                        tempTail.next = newHead;
                    // 开始翻转的节点next连接到后续上面
                    if (tempHead != null)
                        tempHead.next = node;
                    break;
                }
                p = node;
            } else {
                p = p.next;
            }
        }
        if (m > 1) {
            return head;
        } else {
            return newHead;
        }
    }
}
