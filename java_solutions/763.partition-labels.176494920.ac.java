/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (71.69%)
 * Total Accepted:    60.4K
 * Total Submissions: 84.3K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * 
 * 
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * 
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        int start = 0;
        int anchor = 0;
            
        for (int index = 0;index < S.length(); index ++) {
            String temp = String.valueOf(S.charAt(index));
            anchor = Math.max(anchor,S.lastIndexOf(temp));
            if (anchor == index) {
                result.add(index - start + 1);
                start = index + 1;
            }
        }
        return result;
    }
}
