/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (42.67%)
 * Total Accepted:    239K
 * Total Submissions: 560.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, result, 0);
        for (int index = 0; index < result.size(); index++) {
            if (index % 2 != 0) {
                Collections.reverse(result.get(index));
            }
        }
        return result;
    }
    
    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> result, int height) {
        if (root == null)
            return;
        if (height >= result.size()) 
            result.add(new LinkedList<Integer>());
        result.get(height).add(root.val);
        zigzagLevelOrder(root.left, result,height+1);
        zigzagLevelOrder(root.right, result,height+1);
    }
}
