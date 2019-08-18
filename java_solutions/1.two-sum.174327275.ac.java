/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.39%)
 * Total Accepted:    2M
 * Total Submissions: 4.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        
        for (int index = 0; index < nums.length; index++) {
            int number = nums[index];
            if (!dict.containsKey(number)) {
                dict.put(target - number,index);
            }
            else {
                result[0] = dict.get(number);
                result[1] = index;
                break;
            }
                
        }
        return result;
    }
}
