/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * algorithms
 * Medium (39.11%)
 * Total Accepted:    11.2K
 * Total Submissions: 28.7K
 * Testcase Example:  '[1,0,1,0,1]\n2'
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation: 
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 * 
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> storeSumCount = new HashMap<Integer, Integer>();
        storeSumCount.put(0,1);
        int result=0, sum=0;
        
        for (int i = 0; i < A.length; i++) {
            //sum up to ith index
            sum += A[i];
            if (storeSumCount.containsKey(sum-S))
                result += storeSumCount.get(sum-S);
            //store the sum upto ith index in the map
            storeSumCount.put(sum, storeSumCount.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
