/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (53.59%)
 * Total Accepted:    415.3K
 * Total Submissions: 775K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            dict.put(nums[i], dict.getOrDefault(nums[i],0)+1);
        }
        for (int key: dict.keySet()) {
            if (dict.get(key) > n/2)
                return key;
        }
        return -1;
    }
}
