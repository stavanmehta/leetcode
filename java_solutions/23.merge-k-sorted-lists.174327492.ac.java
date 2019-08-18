/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (35.48%)
 * Total Accepted:    426.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (ListNode list:lists) {
            while (list != null) {
                result.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(result);
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int number : result) {
            curr.next = new ListNode(number);
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
