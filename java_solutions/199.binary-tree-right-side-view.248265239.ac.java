/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (48.90%)
 * Total Accepted:    182.6K
 * Total Submissions: 373.5K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        //level order traversal - just add the last value
        //also traverse right side first
        List<Integer> result = new ArrayList<Integer>();
        levelOrderTraversal(root, result, 0);
        return result;
    }
    
    private void levelOrderTraversal(TreeNode root, List<Integer> result, int height) {
        if (root == null)
            return;
        if (height >= result.size())
            result.add(root.val);
        levelOrderTraversal(root.right, result, height+1);
        levelOrderTraversal(root.left, result, height+1);
    }
}
