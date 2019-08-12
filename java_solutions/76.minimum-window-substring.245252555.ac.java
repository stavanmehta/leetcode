/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (31.53%)
 * Total Accepted:    259.2K
 * Total Submissions: 821.9K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        //template solution
        if (t.length() > s.length())
            return "";
        
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (char c:t.toCharArray())
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        
        int counter = frequency.size();
        int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE;
        
        while (end < s.length()) {
            char current = s.charAt(end);
            if (frequency.containsKey(current)) {
                frequency.put(current, frequency.get(current)-1);
                if (frequency.get(current) == 0)
                    counter--;
            }
            end++;
            
            while (counter == 0) {
                char temp = s.charAt(begin);
                if (frequency.containsKey(temp)) {
                    frequency.put(temp, frequency.get(temp)+1);
                    if (frequency.get(temp) > 0)
                        counter++;
                }
                if (end-begin < len) {
                    len = end-begin;
                    head = begin;
                }
                begin++;
            }
        }
        if (len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}
