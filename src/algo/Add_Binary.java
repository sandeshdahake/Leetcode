package algo;

/**
 * https://leetcode.com/problems/add-binary/
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int rem = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                rem += (a.charAt(i) - '0');
            }
            if (j >= 0) {
                rem += (b.charAt(j) - '0');
            }
            result.append((rem % 2));
            rem /= 2;
            i--;
            j--; 
        }
        if (rem > 0) {
            result.append(rem);
        }
        return result.reverse().toString();
    }
}
