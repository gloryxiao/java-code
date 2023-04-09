package com.sean.code.leet;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class Code2 {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (null == l1 || null == l2) {
                return null;
            }

            ListNode tail = null;
            ListNode head = null;
            int gard = 0;
            while (null != l1 && null != l2) {
                int vaule= l1.val + l2.val + gard;
                gard = vaule/10;
                vaule %= 10;
                ListNode cal = new ListNode(vaule);
                if (null == head) {
                    head = cal;
                } else {
                    if (null == tail) {
                        head.next = cal;
                        tail = cal;
                    } else {
                        tail.next = cal;
                        tail = cal;
                    }
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            while (null != l1) {
                int value = l1.val + gard;
                gard = value / 10;
                value %= 10;
                ListNode cal = new ListNode(value);
                if (null == tail) {
                    head.next = cal;
                    tail = cal;
                } else {
                    tail.next = cal;
                    tail = cal;
                }

                l1 = l1.next;
            }

            while (null != l2) {
                int value = l2.val + gard;
                gard = value / 10;
                value %= 10;
                ListNode cal = new ListNode(value);
                if (null == tail) {
                    head.next = cal;
                    tail = cal;
                } else {
                    tail.next = cal;
                    tail = cal;
                }

                l2 = l2.next;
            }

            if (gard > 0) {
                ListNode cal = new ListNode(gard);
                if (null == tail) {
                    head.next = cal;
                    tail = cal;
                } else {
                    tail.next = cal;
                    tail = cal;
                }
            }

            return head;
        }
    }
}
