class Solution {
    
    
    public int numIslands(char[][] grid) {
        int islands = 0;    
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid,row,col, grid.length, grid[0].length);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs (char[][] grid, int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol)
            return;
       
        if (grid[row][col] != '1')
            return;
        
        grid[row][col] = '0';
        
        dfs (grid, row + 1, col,maxRow, maxCol);
        dfs (grid, row - 1, col,maxRow, maxCol);
        dfs (grid, row, col + 1,maxRow, maxCol);
        dfs (grid, row, col - 1,maxRow, maxCol);
    }
}
