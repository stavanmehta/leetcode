/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (56.09%)
 * Total Accepted:    647.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /*
        //iterative solution
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null) {
            ListNode tempHead = current.next;
            current.next = prev;
            prev = current;
            current = tempHead;
        }
        return prev;
        */
        return reverseList(head, null);
    }
    
    public ListNode reverseList(ListNode head, ListNode newHead) {
        //recursive solution
        if (head == null)
            return newHead;
        ListNode temp = head.next;
        head.next = newHead;
        return reverseList(temp,head);
    }
}
