/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.29%)
 * Total Accepted:    372.2K
 * Total Submissions: 661.3K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, n, "", 0, 0);
        return result;
    }
    
    public void backtrack(List<String> result, int max, String temp, int open, int close) {
        if (temp.length() == max*2) {
            result.add(temp);
            return;
        }
        
        if (open < max)
            backtrack(result, max, temp + "(", open + 1, close);
        if (close < open)
            backtrack(result, max, temp + ")", open, close+1);
        return;
    }
}
