/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (44.26%)
 * Total Accepted:    107.4K
 * Total Submissions: 242.7K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >= 0 ) {
            int val1 = i >= 0 ? num1.charAt(i--) - '0':0;
            int val2 = j >= 0 ? num2.charAt(j--) - '0':0;
            int sum = (val1+val2+carry)%10; 
            carry = (val1+val2+carry)/10;
            sb.append(sum+"");
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
