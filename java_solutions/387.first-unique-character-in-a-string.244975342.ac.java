/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.44%)
 * Total Accepted:    298.9K
 * Total Submissions: 592.6K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty())
            return -1;
        
        int length = s.length();
        
        if (length == 1)
            return 0;
        
        for (int index = 0; index < length; index++) {
            char current = s.charAt(index);
            if (s.indexOf(""+current) == index && s.substring(index+1, length).indexOf(""+current) == -1)
                return index;
        }
        return -1;
    }
}
