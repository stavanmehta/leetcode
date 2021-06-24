# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        l1List = []
        while headA != None:
            l1List.append(headA.val)
            headA = headA.next

        while headB != None:
            if headB.val in l1List:
                return headB
            headB = headB.next
        return None
