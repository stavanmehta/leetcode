/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 *
 * algorithms
 * Hard (47.53%)
 * Total Accepted:    76.2K
 * Total Submissions: 160.3K
 * Testcase Example:  '"eceba"'
 *
 * Given a string s , find the length of the longest substring t  that contains
 * at most 2 distinct characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * 
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int counter = 0, begin = 0, end = 0, result = 0;
        
        while (end < s.length()) {
            char current = s.charAt(end);
            map.put(current, map.getOrDefault(current,0)+1);
            if (map.get(current) == 1)
                counter++;
            end++;
            while (counter > 2) {
                char temp = s.charAt(begin);
                map.put(temp, map.get(temp)-1);
                if (map.get(temp) == 0)
                    counter--;
                begin++;
            }
            result = Math.max(result, end - begin);
        }
        return result;
    }
}
