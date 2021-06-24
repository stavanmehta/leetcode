# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.max_depth = 0
        def findDepth(node, depth):
            self.max_depth = max(self.max_depth, depth)
            if not node:
                return
            findDepth(node.left, depth+1)
            findDepth(node.right, depth+1)
        findDepth(root, 0)
        return self.max_depth
