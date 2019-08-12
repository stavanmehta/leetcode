/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (58.20%)
 * Total Accepted:    91.9K
 * Total Submissions: 157.9K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the
 * island must be connected 4-directionally.
 * 
 * Example 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 * 
 */
class Solution {
    int[][] grid;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea  = Math.max(maxArea, getIslandCount(i, m, j, n));
            }
        }
        return maxArea;
    }
    
    private int getIslandCount(int row, int rowMax, int col, int colMax) {
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax || grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        return (1 + getIslandCount(row+1, rowMax, col, colMax) + getIslandCount(row-1, rowMax, col, colMax) +
                getIslandCount(row, rowMax, col-1, colMax) + getIslandCount(row, rowMax, col+1, colMax));
    }
    
}
