/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (35.74%)
 * Total Accepted:    209.9K
 * Total Submissions: 587.2K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         /* initial solution
        for (int i =0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length;j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k)
                    return true;
            }
        }
        return false;
        */
        /*
        optimized solution
        */
        Set<Integer> duplicate = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicate.contains(nums[i])) return true;
            duplicate.add(nums[i]);
            if (duplicate.size() > k) {
                duplicate.remove(nums[i-k]);
            }
        }
        return false;
    }
}
