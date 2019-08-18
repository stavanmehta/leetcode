# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        from collections import defaultdict
        self.levelList = defaultdict(list)
        
        def getLevelOrder(root, level):
            if not root:
                return
            self.levelList[level].append(root.val)
            getLevelOrder(root.left, level+1)
            getLevelOrder(root.right, level+1)
        
        getLevelOrder(root, 0)
        return self.levelList.values()
        
