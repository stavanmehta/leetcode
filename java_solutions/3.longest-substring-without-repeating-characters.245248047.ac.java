/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.69%)
 * Total Accepted:    1M
 * Total Submissions: 3.6M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*template based solution
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int begin = 0, end = 0, counter = 0, result = 0;
        
        while (end < s.length()) {
            char current = s.charAt(end);
            map.put(current, map.getOrDefault(current, 0)+1);
            if (map.get(current) > 1)
                counter++;
            end++;
            
            while (counter > 0) {
                char temp = s.charAt(begin);
                if (map.get(temp) > 1)
                    counter--;
                map.put(temp, map.get(temp)-1);
                begin++;
            }
            result = Math.max(result, end-begin);
        }
        return result;
        */
        
        Set<Character> store = new HashSet<Character>();
        int i = 0, j = 0, n = s.length(), result = 0;
        
        while (i < n && j < n) {
            char current = s.charAt(j);
            if (!store.contains(current)) {
                store.add(current);
                j++;
                result = Math.max(result, j-i);
            } else {
                store.remove(s.charAt(i));
                i++;
            }
        }
        return result;
        
    }
}
