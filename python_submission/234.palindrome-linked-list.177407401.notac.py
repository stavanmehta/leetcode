# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        nodeVal = ""
        while head is not None:
            nodeVal += str(head.val)
            head = head.next
        print nodeVal
        return nodeVal == nodeVal[::-1]
