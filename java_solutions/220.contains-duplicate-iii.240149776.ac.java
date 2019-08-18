/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (19.97%)
 * Total Accepted:    97.7K
 * Total Submissions: 488.9K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //solution1
        TreeSet<Integer> set = new TreeSet<>();
        /**
        Initialize an empty BST set
        Loop through the array, for each element x
        Find the smallest element s in set that is greater than or equal to x, return true if s - x <= t
        Find the greatest element g in set that is smaller than or equal to x, return true if x - g <= t
        Put x in set
        If the size of the set is larger than k, remove the oldest item.
        Return false
        */
        for (int i = 0; i < nums.length; i++) {
            Integer succ = set.ceiling(nums[i]);
            if (succ != null && succ <= t+nums[i])
                return true;
            
            Integer pred = set.floor(nums[i]);
            if (pred != null && nums[i] <= t+pred)
                return true;
            set.add(nums[i]);
            
            if (set.size() > k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}
