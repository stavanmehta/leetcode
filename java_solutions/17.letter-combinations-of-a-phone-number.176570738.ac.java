/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (42.49%)
 * Total Accepted:    424.9K
 * Total Submissions: 999.9K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        List<String> digitLetter = Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        
        if (digits.length() == 0) return result;
        
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            result = combine(digitLetter.get(Character.getNumericValue(digits.charAt(i))),result);
        }
        
        return result;
    }
    
    public List<String> combine(String S, List<String> list) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < S.length(); i++) {
            for (String x: list){
                result.add(x+S.charAt(i));
            }
        }
        return result;
    }
}
