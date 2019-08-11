/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (42.62%)
 * Total Accepted:    123.8K
 * Total Submissions: 290.6K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 * 
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> checkSum = new HashMap<Integer, Integer>();
        checkSum.put(0,1);
        int sum = 0, result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            //sum upto ith index
            sum+=nums[i];
            if (checkSum.containsKey(sum-k))
                result+= checkSum.get(sum-k);
            //store the sum upto ith index in the map
            checkSum.put(sum, checkSum.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
