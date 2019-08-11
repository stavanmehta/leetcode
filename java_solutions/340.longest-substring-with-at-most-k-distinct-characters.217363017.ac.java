/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (40.50%)
 * Total Accepted:    81.7K
 * Total Submissions: 201.7K
 * Testcase Example:  '"eceba"\n2'
 *
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, end = 0, maxLen = 0, counter = 0;
         
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            if (map.get(c) == 1)
                counter++;
            end++;
            while (counter > k) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp)-1);
                if (map.get(cTemp) == 0)
                    counter--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
