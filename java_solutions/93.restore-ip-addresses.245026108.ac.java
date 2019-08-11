/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (32.12%)
 * Total Accepted:    148K
 * Total Submissions: 460.8K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();
    
    public boolean isValid(String segment) {
        /*
        Check if the current segment is valid:
        1. less or equal to 255
        2. the first character could be '0'
        only if the segment is equal to '0'
        */
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }
    
    public void updateOutput(int currPos) {
        /*
        Append the current list of segments
        to the list of solutions
        */
        String segment = s.substring(currPos+1, n);
        if (isValid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }
    
    public void backtrack(int prevPos, int dots) {
        /*
        prev_pos - the position of the previously placed dot
        dots: number of dots to place
        */
        // The current dot curr_pos could be placed 
        // in a range from prev_pos + 1 to prev_pos + 4
        // The dot couldn't be placed
        // after the last character in the string.
        int max_pos = Math.min(n-1, prevPos+4);
        for (int curr_pos = prevPos+1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prevPos + 1, curr_pos + 1);
            if (isValid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0)
                    updateOutput(curr_pos);
                else
                    backtrack(curr_pos, dots - 1);
                segments.removeLast();
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }
}
