/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (38.92%)
 * Total Accepted:    174.5K
 * Total Submissions: 448.2K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n*k == 0)
            return new int[0];
        int[] result = new int[n-k+1];
        /* initial solution
        for (int index = 0; index < n-k+1; index++) {
                //sliding window now find max 
                int max = Integer.MIN_VALUE;
                for (int jindex = index; jindex < index+k; jindex++) 
                    max = Math.max(max, nums[jindex]);
                result[index] = max;
        }
        */
        //optimized solution in linear time
        int [] left = new int[n];
        int [] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) //block start
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i-1],nums[i]);
            int j = n-i-1;
            if ((j+1) % k == 0) //block end
                right[j] = nums[j];
            else
                right[j] = Math.max(right[j+1], nums[j]);
        }
        
        for (int i = 0; i < n - k + 1; i++) 
            result[i] = Math.max(left[i+k-1], right[i]);
        return result;
    }
}
