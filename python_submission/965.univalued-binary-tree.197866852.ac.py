# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isUnivalTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        treeset = set()
        
        if root is None:
            return False
        
        def helper(node):
            if not node:
                return
            if node.val is not None:
                treeset.add(node.val)
            helper(node.left)
            helper(node.right)
            
        helper(root)
        return len(treeset) == 1
