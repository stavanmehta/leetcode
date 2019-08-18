/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (55.35%)
 * Total Accepted:    146.8K
 * Total Submissions: 265.2K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1:
 * 
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 * 
 * 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = nums[0], result = nums[0], start = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] == 1 && nums[i] == nums[start]) {
                counter++;
                result = Math.max(counter, result);
            } else 
                counter = nums[i];
            start = i;
        }
        return Math.max(counter, result);
    }
}
