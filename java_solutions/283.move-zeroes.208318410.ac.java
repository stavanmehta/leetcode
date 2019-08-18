/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (54.85%)
 * Total Accepted:    502.7K
 * Total Submissions: 916.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                nums[counter] = nums[index];
                if (counter != index)
                    nums[index] = 0;
                counter++;
            }  
        }
        return;
    }
}
