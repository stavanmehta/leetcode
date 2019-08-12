/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (64.90%)
 * Total Accepted:    137.6K
 * Total Submissions: 212K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;
        String[] tokens = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            for (int j = token.length()-1; j >= 0; j--) {
                result.append(token.charAt(j)+"");
            }
            if ( i != tokens.length-1)
                result.append(" ");
        }
        // int length = tokens.length;
        
        // for (int k = tokens[length-1].length()-1; k >=0; k--)
            // result.append(tokens[length-1].charAt(k)+"");
        return result.toString();
    }
}
