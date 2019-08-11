/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (32.73%)
 * Total Accepted:    107.9K
 * Total Submissions: 329.8K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int num1 = 0, num2 = 0;
        for (int num: nums) {
            if (num1 == num)
                count1++;
            else if (num2 == num)
                count2++;
            else if (count1 == 0) {
                num1 = num;
                count1= 1;
            }
            else if (count2 == 0) {
                num2 = num;
                count2=1;
            }
            else {
                count1--;
                count2--;
            }
        }
        int totalCount1 = 0, totalCount2 = 0;
        for (int num:nums) {
            if (count1 > 0 && num == num1) totalCount1++;
            if (count2 > 0 && num == num2) totalCount2++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(totalCount1 > nums.length/3) result.add(num1);
        if(totalCount2 > nums.length/3) result.add(num2);
        
        return result;
    }
}
