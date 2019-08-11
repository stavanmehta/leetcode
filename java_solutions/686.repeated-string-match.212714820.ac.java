/*
 * @lc app=leetcode id=686 lang=java
 *
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (31.59%)
 * Total Accepted:    72K
 * Total Submissions: 227.9K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 * 
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.isEmpty() || A == null)
            return -1;
        int count = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.indexOf(B) < 0) {
            if (sb.length()-A.length() > B.length())
                return -1;
            count++;
            sb.append(A);
        }
        return count;
    }
}
