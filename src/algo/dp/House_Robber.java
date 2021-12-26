package algo.dp;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class House_Robber {
    public int rob(int[] nums)
    {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int res =calculate(nums,0,dp);
        return res;
    }
    public static int calculate(int arr[],int curr,int dp[])
    {
        if(curr>=arr.length)
        {
            return 0;
        }
        if(dp[curr]!=-1)
        {
            return dp[curr];
        }
        int rob=0;
        int norob=0;
        rob=calculate(arr,curr+2,dp)+arr[curr];
        norob=calculate(arr,curr+1,dp);
        return dp[curr]=Math.max(rob,norob);
    }

}
