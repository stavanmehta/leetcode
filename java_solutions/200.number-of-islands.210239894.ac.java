/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (42.38%)
 * Total Accepted:    396.2K
 * Total Submissions: 934.9K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int numOfIslands = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(i, j, m, n, grid);
                 }
            }
        }
        return numOfIslands;
    }
    
    public void dfs(int i, int j, int m, int n, char[][] grid) {
        if ( i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' ) 
            return;
        
        grid[i][j] = '0';
        
        dfs(i+1, j , m , n, grid );
        dfs(i, j+1 , m , n, grid );
        dfs(i-1, j , m , n, grid );
        dfs(i, j-1 , m , n, grid );
    }
}
