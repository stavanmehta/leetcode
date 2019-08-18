# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        valList = []
        for node in lists:
            while node != None:
                valList.append(node.val)
                node = node.next
        valList = sorted(valList)

        sortedNode = currentNode = None
        for val in valList:
            node = ListNode(val)
            if not sortedNode:
                sortedNode = node
                currentNode = node
            else:
                currentNode.next = node
                currentNode = node
        return sortedNode
