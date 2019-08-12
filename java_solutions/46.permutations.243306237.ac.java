/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (56.61%)
 * Total Accepted:    413.8K
 * Total Submissions: 731.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        /*
        //iterative solution
        if (nums.length == 0)
            return result;
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        result.add(first);
        
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (int index = 0; index <= i; index++) {
                for (List<Integer> tempList:result) {
                    List<Integer> newList = new ArrayList<>(tempList);
                    newList.add(index, nums[i]);
                    temp.add(newList);
                }
            }
            result = temp;
        }
        
        */
        //recursive solution
        backtrack(result, nums, new ArrayList<>());
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length)
            result.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                List<Integer> current = new ArrayList<>(tempList);
                current.add(nums[i]);
                backtrack(result, nums, current);
                // tempList.remove(tempList.size()-1);
            }
        }
        return;
    }
}
