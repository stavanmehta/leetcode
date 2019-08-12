/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.79%)
 * Total Accepted:    368.7K
 * Total Submissions: 805.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int result = nums[0] + nums[1] + nums[length - 1];
        Arrays.sort(nums);
        
        for (int index = 0; index < length - 2; index++) {
            int start = index + 1;
            int end = length - 1;
            
            while (start < end) {
                int sum = nums[start] + nums[index] + nums[end];
                
                if (sum < target)
                    start++;
                else
                    end--;
                if (Math.abs(target-sum) < Math.abs(target-result))
                    result = sum;
            }
        }
        return result;
    }
}
