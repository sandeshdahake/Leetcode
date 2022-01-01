package algo.dp;

/**
 * https://leetcode.com/problems/burst-balloons/
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 500
 * 0 <= nums[i] <= 100
 */
public class Burst_Balloons {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;  // PAD 1 on both the sides ,If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
        int[] arr = new int[n];
        int[][] dp = new int[n][n];

        arr[0] = 1;   // [1,0,0,0,0,0]
        arr[arr.length - 1] = 1; // [1,0,0,0,0,1]

        for (int i = 1; i <= nums.length; i++) arr[i] = nums[i-1]; // [1,3,1,5,8,1]

        for (int len = 0; len < n; len++) {
            for (int j = len; j < n; j++) {
                int i = j - len;
                int prod = arr[i] * arr[j];
                int temp = 0;

                for (int k = i + 1; k < j; k++) {
                    temp = Math.max(temp, dp[i][k] + dp[k][j] + arr[k]*prod);
                }

                dp[i][j] = temp;
            }
        }

        return dp[0][n - 1];
    }
}
