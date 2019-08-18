/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (55.99%)
 * Total Accepted:    284.6K
 * Total Submissions: 508.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tmp = 1;
        int[] result = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            result[index] =tmp;
            tmp *= nums[index];
        }
        tmp = 1;
        for (int jindex = nums.length-1; jindex >=0; jindex--) {
            result[jindex]*= tmp;
            tmp *= nums[jindex];
        }
        return result;
    }
}
