/*
 * @lc app=leetcode id=616 lang=java
 *
 * [616] Add Bold Tag in String
 *
 * https://leetcode.com/problems/add-bold-tag-in-string/description/
 *
 * algorithms
 * Medium (39.77%)
 * Total Accepted:    25.4K
 * Total Submissions: 64K
 * Testcase Example:  '"abcxyz123"\n["abc","123"]'
 *
 * Given a string s and a list of strings dict, you need to add a closed pair
 * of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If
 * two such substrings overlap, you need to wrap them together by only one pair
 * of closed bold tag. Also, if two substrings wrapped by bold tags are
 * consecutive, you need to combine them. 
 * 
 * Example 1:
 * 
 * Input: 
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * 
 * 
 * 
 * Note:
 * 
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000]. 
 * 
 * 
 */
class Solution {
    public String addBoldTag(String s, String[] dict) {
        //maintain a posit
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) { // For every character in `s`,
            for (String word : dict) { // For every `word` in `dict`, we test:
            // If substring s[i, i + word.length()] == word, meaning characters between i, 
            // i + word.length() should be `bold`.
                if (s.startsWith(word, i)) {
                // Use variable `end` to store known longest end of current continuous `bold` characters
                end = Math.max(end, i + word.length());
                }
            }
        // If `end` > `i`, meaning character at position `i` is within the current continuous `bold`
        // characters, we mark it as `bold`.
            bold[i] = end > i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < s.length(); k++) {
            if (!bold[k]) {
                result.append(s.charAt(k));
                continue;
            }
            
            int j = k;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>").append(s.substring(k,j)).append("</b>");
            k = j - 1;
        }
        return result.toString();
    }
}
