/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.56%)
 * Total Accepted:    256.9K
 * Total Submissions: 868.9K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        int found = 0;
        for (int i = 1; i < n; i++) {
            if(isPrime(i))
                found++;
        }
        return found;
    }
    
    public static Boolean isPrime(int number) {
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        int max = (int) Math.round(Math.sqrt(number));
        for (int i = 3; i <= max; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
