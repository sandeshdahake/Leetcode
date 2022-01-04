package algo;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 *
 * Input: n = 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 *
 * Input: n = 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 *
 * Constraints:
 *
 * 0 <= n < 109
 *
 */
public class Complement_Base_10_Integer {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1; // Checking for base case
        int res = 0;
        int fac = 1; // keep for 2 basically

        while(n != 0){
            // first we need to check what is our bit in 2 by taking modulo
            res += fac * (n % 2 == 0 ? 1 : 0);
            // res is the number convert back to decimal + factor * n % 2 if comes 0 then we take 1 otherwise 0 this is our complement

            fac *= 2;
            n /= 2;
        }
        return res;
    }
}
