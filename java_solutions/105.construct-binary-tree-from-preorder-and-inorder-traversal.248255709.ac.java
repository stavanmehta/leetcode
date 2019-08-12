/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (42.42%)
 * Total Accepted:    242.9K
 * Total Submissions: 572.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        Map<Integer, Integer> inOrderLookup = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inOrderLookup.put(inorder[i],i);
        return buildTree(preorder, inorder, 0, preorder.length-1, inOrderLookup);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> inOrderLookup) {
        if (start > end || index >= inorder.length) 
            return null;
        int inorderIndex = inOrderLookup.get(preorder[index++]);
        TreeNode root = new TreeNode(inorder[inorderIndex]);
        root.left = buildTree(preorder, inorder, start, inorderIndex-1, inOrderLookup);
        root.right = buildTree(preorder, inorder, inorderIndex+1, end, inOrderLookup);
        return root;
    }
}
