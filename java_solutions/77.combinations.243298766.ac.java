/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (48.99%)
 * Total Accepted:    217.7K
 * Total Submissions: 444.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
class Solution {
    List<List<Integer>> result = new LinkedList();
    public List<List<Integer>> combine(int n, int k) {
        generateCombinations(n, k, 1, new LinkedList<>());
        return result;
    }
    
    public void generateCombinations(int n, int combinationLength, int start, LinkedList<Integer> combination) {
        if (combinationLength == combination.size())        
            result.add(new LinkedList<>(combination));
        for (int i = start; i<=n; i++) {
            combination.add(i);
            generateCombinations(n, combinationLength, i + 1, combination);
            combination.removeLast();
        }
        return;
    }
}
