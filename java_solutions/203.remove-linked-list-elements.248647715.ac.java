/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (36.20%)
 * Total Accepted:    240.9K
 * Total Submissions: 665.4K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val && head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head, prev = dummy;
        
        while (current != null) {
            ListNode temp = current.next;
            if (current.val == val) {
                prev.next = temp;
            } else
                prev = prev.next;
            current = current.next;
        }
        return dummy.next;
    }
}
