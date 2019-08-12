/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.28%)
 * Total Accepted:    286.6K
 * Total Submissions: 887.8K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty())
            return 0;
        String[] tokens = s.split("\\s+");
        if (tokens.length == 0)
            return 0;
        return tokens[tokens.length-1].length();
        
    }
}
