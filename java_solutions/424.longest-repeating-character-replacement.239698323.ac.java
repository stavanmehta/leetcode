/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (44.65%)
 * Total Accepted:    35.1K
 * Total Submissions: 78.7K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it
 * to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxLength = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        while (end < s.length()) {
            char cTemp = s.charAt(end);
            map.put(cTemp, map.getOrDefault(cTemp, 0 )+1);
            counter = Math.max(counter, map.get(cTemp));
            while (end - start + 1 - counter > k) {
                char c = s.charAt(start++);
                map.put(c, map.get(c)-1);
            }
            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        return maxLength;
    }
}
