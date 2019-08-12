/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (48.00%)
 * Total Accepted:    249.5K
 * Total Submissions: 519.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j != n)
                    grid[i][j] += grid[i][j+1];
                else if (i != m && j == n)
                    grid[i][j] += grid[i+1][j];
                else if (i != m && j != n)
                    grid[i][j] += Math.min(grid[i][j+1], grid[i+1][j]);
            }
        }
        return grid[0][0];
    }
}
