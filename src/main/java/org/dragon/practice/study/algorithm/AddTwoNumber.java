package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 您将获得两个非空链接列表，它们表示两个非负整数。这些数字以相反的顺序存储，并且它们的每个节点都包含一个数字/
 * 将两个数字相加，并将其作为链表返回。 您可能假设两个数字不包含任何前导零，除了number 0本身。
 *
 * @Author: Liuwl
 * Date: 2020/5/19
 **/
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode next = null;
        ListNode p = res;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + p.val;
            next = new ListNode(sum / 10);
            p.val = sum % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null && p.next != null && p.next.val == 0) {
                break;
            } else {
                p.next = next;
                p = p.next;
            }
        }

        return res;
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
}


