/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges/description/
 *
 * algorithms
 * Medium (23.42%)
 * Total Accepted:    60K
 * Total Submissions: 256.4K
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * Given a sorted integer array nums, where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * 
 * Example:
 * 
 * 
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * 
 * 
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();   
        if (nums.length == 0) {
            result.add(generateRange(lower, upper));
            return result;
        }
        if (lower == Integer.MAX_VALUE)
            return result;
        
        int next = lower;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next)
                continue;
            if (nums[i] == next) {
                next = next + 1;
                continue;
            }
            
            result.add(generateRange(next, nums[i]-1));
            
            if (nums[i] == upper)
                return result;
            
            next = nums[i]+1;
        }
        if (next <= upper) 
            result.add(generateRange(next, upper));
        return result;
    }
    
    private String generateRange(int start, int end) {
        if (start == end)
            return ""+start;
        return start+"->"+end;
    }
}
