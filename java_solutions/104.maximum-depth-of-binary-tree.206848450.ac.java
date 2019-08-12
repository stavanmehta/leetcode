/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (61.52%)
 * Total Accepted:    553.5K
 * Total Submissions: 899.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
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
public class Solution {
    int result;
    public int maxDepth(TreeNode root) {
        //top down approach
        if (root == null)
            return result;
        //bottom-up approach
        findMaxDepth(root,1);
        return result;
        //return findMaxDepth(root);
    }
    
    private void findMaxDepth(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            result = Math.max(result,depth);
        findMaxDepth(root.left, depth+1);
        findMaxDepth(root.right, depth+1);
    }
    private int findMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findMaxDepth(root.left),findMaxDepth(root.right));
    }
}
