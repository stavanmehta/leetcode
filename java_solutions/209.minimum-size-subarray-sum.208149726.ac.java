/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (35.36%)
 * Total Accepted:    188.8K
 * Total Submissions: 534K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int index = 0;
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        
        while (index < nums.length) {
            sum += nums[index];
            
            while (sum >= s) {
                min = Math.min(min, index + 1 - left);
                sum -= nums[left++];
            }
            index++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
