/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (29.74%)
 * Total Accepted:    229.1K
 * Total Submissions: 770.1K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        /* initial solution
        int max = nums[0];
        for (int index = 0; index < nums.length; index++) {
            int currentNumber = nums[index];
            for (int jindex = index+1; jindex < nums.length; jindex++) {
                max = Math.max(currentNumber, max);
                currentNumber*=nums[jindex];
            }
            max = Math.max(currentNumber, max);
        }
        return max;
        */
        //optimized solution
        
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0], min = nums[0], result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >=0) {
                max = Math.max(nums[i]*max, nums[i]);
                min = Math.min(nums[i]*min, nums[i]);
            } else {
                int temp = max;
                max = Math.max(min*nums[i], nums[i]);
                min = Math.min(temp*nums[i],nums[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
