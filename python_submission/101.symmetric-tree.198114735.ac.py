# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        p = q = root
        return self.isMirror(p, q)

    def isMirror(self, p, q):

        if p and q:
            return p.val == q.val and self.isMirror(p.left, q.right) and self.isMirror(p.right, q.left)
        else:
            # print p.val, q.val
            return p == q
