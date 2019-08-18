/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (36.53%)
 * Total Accepted:    137.1K
 * Total Submissions: 375.2K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0)
            return result;
        int lower = nums[0];
        int upper = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index-1] + 1) {
                upper = nums[index];
                continue;
            }
                
            result.add(generateRange(lower, nums[index-1]));
            lower = nums[index];
        }
        if (lower < upper)
            result.add(generateRange(lower, upper));
        else
            result.add(Integer.toString(lower));
        return result;
    }
    
    private String generateRange(int start, int end) {
        if (start == end)
            return ""+start;
        return start+"->"+end;
    }
}
