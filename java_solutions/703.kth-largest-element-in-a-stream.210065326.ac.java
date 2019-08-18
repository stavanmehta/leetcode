/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 *
 * algorithms
 * Easy (46.77%)
 * Total Accepted:    39.3K
 * Total Submissions: 84.1K
 * Testcase Example:  '["KthLargest","add","add","add","add","add"]\n' +
  '[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]'
 *
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 * 
 * Example:
 * 
 * 
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 
 * 
 * Note: 
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * 
 */
class KthLargest {
    TreeNode root;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums)
            root = insertBST(root, num);
    }
    
    private TreeNode insertBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        root.count++;
        if (root.val > val)
            root.left = insertBST(root.left, val);
        else
            root.right = insertBST(root.right,val);
        return root;
    }
    public int add(int val) {
        root = insertBST(root, val);
        return findKthLargest();
    }
    
    public int findKthLargest() {
        int count = k;
        TreeNode current = root;
        
        while (count > 0) {
            int pos = 1 + (current.right != null ? current.right.count : 0);
            if (count == pos)
                break;
            if (count < pos) {
                current = current.right;
            } else {
                count-=pos;
                current = current.left;
            }
        }
        return current.val;
    }
    
    public class TreeNode {
      int val;
      int count = 1;
      TreeNode left, right;
      TreeNode(int x) { val = x; }
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
