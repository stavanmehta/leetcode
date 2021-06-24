# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.sum = 0
        result = ""
        def add_numbers(root, result):
            if not root:
                return
            result += str(root.val)
            if root.left is None and root.right is None:
                self.sum += int(result)

            add_numbers(root.left, result)
            add_numbers(root.right, result)

        add_numbers(root, result)
        return self.sum
