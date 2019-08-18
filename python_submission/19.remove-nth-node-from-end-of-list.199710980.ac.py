# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        prehead = ListNode(0)
        prehead.next = head
        
        p1 = prehead; p2 = prehead
        
        # Advance one pointer by n times
        for _ in range(n):
            p2 = p2.next
            
        # Advance both pointers until the faster pointer
        # hits the last node
        while p2.next:
            p1 = p1.next
            p2 = p2.next
        
        p1.next = p1.next.next
        
        return prehead.next
