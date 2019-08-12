/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (39.65%)
 * Total Accepted:    138.3K
 * Total Submissions: 348.8K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int left = 0, right = nums.length - 1;
        
        while (nums[left] == nums[right] && left < right)
            right--;
        
        while (left < right) {
            int mid = left +(right-left)/2;
            if (nums[left] < nums[right])
                return nums[left];
            
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
