# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def closestValue(self, root, target):
        """
        :type root: TreeNode
        :type target: float
        :rtype: int
        """
        self.diff = abs(root.val - target) if root.val else target

        def find_min_diff(root, target):
            if not root and not root.left and not root.right:
                return

            if root.left and root.left.val != None and abs(root.left.val - target) < self.diff:
                self.diff = abs(root.left.val - target)
                return find_min_diff(root.left, target)
            elif root.right and root.right.val != None and abs(root.right.val - target) < self.diff:
                self.diff = abs(root.right.val - target)
                return find_min_diff(root.right, target)
            else:
                return root.val

        return find_min_diff(root, target)

