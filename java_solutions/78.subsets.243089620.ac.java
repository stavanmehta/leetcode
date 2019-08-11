/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (54.25%)
 * Total Accepted:    396.6K
 * Total Submissions: 731K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    /* Iterative solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int num:nums) {
            int size = result.size();
            for (int index = 0; index < size; index++) {
                List<Integer> subset = new ArrayList<>(result.get(index));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
    */
    //Recursive solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return findSubsets(result, 0, nums);
    }
    
    public List<List<Integer>> findSubsets(List<List<Integer>> result, int index, int[] nums) {
        if (index >= nums.length) return result;
        int size = result.size();
        for (int jindex = 0; jindex < size; jindex++) {
            List<Integer> subset = new ArrayList<>(result.get(jindex));
            subset.add(nums[index]);
            result.add(subset);
        }
        return findSubsets(result, index+1, nums);
    }
}
