/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.00%)
 * Total Accepted:    657.3K
 * Total Submissions: 1.8M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> store = new Stack<Character>();
        for (int index = 0; index < s.length(); index++) {
            char current = s.charAt(index);
            if (current == '{' || current == '(' || current == '[') {
                store.push(current);
            } else {
                if (store.isEmpty())
                    return false;
                char opening = store.peek();
                boolean result = checkForMatch(opening, current);
                if (!result)
                    return false;
                else
                    store.pop();
            }
        }
        return store.isEmpty();
    }
    
    private boolean checkForMatch(char open, char close) {
        if (open == '{' && close == '}')
            return true;
        if (open == '(' && close == ')')
            return true;
        if (open == '[' && close == ']')
            return true;
        return false;
    }
}
