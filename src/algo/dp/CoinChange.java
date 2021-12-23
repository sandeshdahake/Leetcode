package algo.dp;

import java.util.HashMap;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *https://leetcode.com/problems/coin-change/
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap();
        //Arrays.fill(memo, -1);
        int ans = helper(coins, amount, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int remain, HashMap<Integer, Integer> memo) {
        if (remain == 0) return 0;
        if (remain < 0) return Integer.MAX_VALUE;
        if (memo.containsKey(remain)) return memo.get(remain);


        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = Math.min(ans, helper(coins, remain - coin, memo));
            if(count != Integer.MAX_VALUE){
                ans = Math.min(ans, count + 1);
            }
        }

        memo.put(remain, ans);
        return memo.get(remain);
    }
}
