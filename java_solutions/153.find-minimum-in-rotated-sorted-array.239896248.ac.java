/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.37%)
 * Total Accepted:    306.7K
 * Total Submissions: 707.1K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int left = 0, right = nums.length-1;
        
        while (left < right) {
            if (nums[left] < nums[right])
                return nums[left];
            
            int mid = left + (right - left)/2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
