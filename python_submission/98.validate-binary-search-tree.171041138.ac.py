# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        def validateBST(min_val, max_val, root):
            if not root:
                return True
            left = validateBST(min_val, root.val, root.left)
            right = validateBST(root.val, max_val, root.right)
            return min_val < root.val < max_val and left and right
            
        return validateBST(-sys.maxsize, sys.maxsize, root)

