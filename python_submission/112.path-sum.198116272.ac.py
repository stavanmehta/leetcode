# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        self.match_sum = False
        def findSum(node, value):
            if not node:
                return
            value += node.val
            if value == sum and not node.left and not node.right:
                self.match_sum = True
                return
            findSum(node.left, value)
            findSum(node.right, value)
        findSum(root, 0)
        return self.match_sum 
        
