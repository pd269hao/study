package org.dragon.practice.study.algorithm;

//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both?
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Created with IntelliJ IDEA.
 * 翻转单链表
 *
 * @Author: Liuwl
 * Date: 2020/6/2
 **/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;

        ListNode p = head;
        while (p != null) {
            ListNode n = p.next;
            p.next = newHead;
            newHead = p;
            p = n;
        }
        return newHead;
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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
