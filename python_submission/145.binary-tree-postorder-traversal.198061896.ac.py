# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        postOrderList = list()
        def helper(node):
            if not node:
                return
            helper(node.left)
            helper(node.right)
            postOrderList.append(node.val)

        helper(root)
        return postOrderList
