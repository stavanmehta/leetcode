/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (40.40%)
 * Total Accepted:    163.5K
 * Total Submissions: 404.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int currentIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currentIndex = postorder.length-1;
        Map<Integer, Integer> inorderLookup = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inorderLookup.put(inorder[i],i);
        return buildTree(inorder, postorder, 0, inorder.length-1, inorderLookup);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> inorderLookup) {
        if (start > end || currentIndex < 0)
            return null;
        int val = postorder[currentIndex--];
        int inorderIndex = inorderLookup.get(val);
        TreeNode root = new TreeNode(val);
        root.right = buildTree(inorder, postorder, inorderIndex+1, end, inorderLookup);
        root.left = buildTree(inorder, postorder, start, inorderIndex-1, inorderLookup);
        return root;
    }
    
}
