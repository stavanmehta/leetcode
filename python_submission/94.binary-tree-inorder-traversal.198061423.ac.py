# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        inOrderList = list()
        def helper(node):
            if not node:
                return
            helper(node.left)
            inOrderList.append(node.val)
            helper(node.right)

        helper(root)
        return inOrderList
