# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        
        prev = ListNode(-1)
        prev.next = head
        curr = head
        while curr:
            if curr.val == val:
                curr = curr.next
                prev.next = curr
            else:
                prev = prev.next
                curr = curr.next
        return head
