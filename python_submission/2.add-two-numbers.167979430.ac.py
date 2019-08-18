# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        listL1, listL2 = "", ""
        while l1 != None:
            if l1:
                listL1 += str(l1.val)
                l1 = l1.next

        while l2 != None:
            if l2:
                listL2 += str(l2.val)
                l2 = l2.next
        sum = (str(int(listL1[::-1]) + int(listL2[::-1])))[::-1]

        sumNode = None
        currentNode = None
        for number in sum:
            node = ListNode(int(number))
            if not sumNode:
                sumNode = node
                currentNode = node
            else:
                currentNode.next = node
                currentNode = node
        return sumNode 
