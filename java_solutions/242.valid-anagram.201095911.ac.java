/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.05%)
 * Total Accepted:    373.3K
 * Total Submissions: 703.7K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        char[] tempS = s.toCharArray();
        char[] tempT = t.toCharArray();
        Arrays.sort(tempS);
        Arrays.sort(tempT);
        String sortedS = new String(tempS);
        String sortedT = new String(tempT);
        return sortedS.equals(sortedT);
    }
}
