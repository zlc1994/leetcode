package _0002;

import util.ListNode;

//2. Add Two Numbers
//
// Medium
//
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            carry = sum / 10;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l2 = l2.next;
            carry = sum / 10;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }
}
