# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None or head.next.next is None:
            return False
        
        counter = -1
        slow = head
        fast = head.next.next
        if slow == fast:
            return True
        
        while slow != fast:
            counter += 1
            slow = slow.next
            if fast.next and fast.next.next:
                fast = fast.next.next
            else:
                return False
            
        return True if counter >= 0 else False
