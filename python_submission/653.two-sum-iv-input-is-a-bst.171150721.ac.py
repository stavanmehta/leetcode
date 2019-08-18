# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTarget(self, root, k, sums=None):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
#         if root is None: return False
#         if sums is None: sums = {}
#         if root.val in sums: return True
#         sums[t - root.val] = root.val
#         return self.findTarget(root.left, t, sums) or self.findTarget(root.right, t, sums)
    
    
        self.values = []
        def BFS(root, k):
            if not root:
                return False
            rootVal = root.val if root.val is not None else 0
            if rootVal in set(self.values):
                return True
            self.values.append(k - rootVal)
            return BFS(root.left, k) or BFS(root.right, k)

        return BFS(root, k)
