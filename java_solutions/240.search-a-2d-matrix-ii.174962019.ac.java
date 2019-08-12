/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (41.19%)
 * Total Accepted:    195.7K
 * Total Submissions: 475.1K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * Example:
 * 
 * Consider the following matrix:
 * 
 * 
 * [
 * ⁠ [1,   4,  7, 11, 15],
 * ⁠ [2,   5,  8, 12, 19],
 * ⁠ [3,   6,  9, 16, 22],
 * ⁠ [10, 13, 14, 17, 24],
 * ⁠ [18, 21, 23, 26, 30]
 * ]
 * 
 * 
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean result = false;
        
        for (int i = 0; i < m; i++) {
            int min = matrix[i][0];
            int max = matrix[i][n-1];
            if (min == target || max == target )
                return true;
            if (min < target && target < max) {
                result = result || binarySearch(target,matrix[i]);
            }
        }
        return result;
    }
    
    public boolean binarySearch(int target, int[]nums) {
        int low = 0;
        int high = nums.length -1;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            
            if (nums[mid] == target)
                return true;
            if (nums[mid] < target)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return false;
    }
}
