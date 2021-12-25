package algo.dp;

import java.util.Arrays;

public class Coin_Change_All_Version {
/**
 *  TYPE 1 : Return the number of combinations ( Count of different ways)
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
 * Space complexity : O(S)O(S). We use extra space for the memoization table.
 * */

    public int change1(int amount, int[] coins) {
        if(amount < 0 ) return 0;  // For negative amounts return 0

        int[] table = new int[amount+1];

        table[0] = 1 ;  // For 0 amount , we can have 1 way that is dont pay

        for(int i=0 ; i< coins.length; i++){    // consider each coin to avoid permutation
            for(int j= coins[i]; j< table.length; j++){  // init j = coin[i]  to avoid negative amount eg  2-5rs coin = -3
                table[j] += table[j - coins[i]];  //  int diff = J - coin    table[j] = table[j] + table[diff]
            }
        }
        /**
             for(int coin: coins){
                 for(int i=coin; i< table.length; i++){
                     int diff = i - coin;
                    table[i] = table[i] + table[diff];
                 }
             }
         */
        return table[amount];
    }

 /**
  * TYPE 2: MIN COINS
  * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
  *
  * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
  *
  * You may assume that you have an infinite number of each kind of coin.
  * Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
  * Space complexity : O(S)O(S). We use extra space for the memoization table.
 */

 public int coinChange2(int[] coins, int amount) {

     int[] table = new int[amount+1];
     Arrays.fill(table, Integer.MAX_VALUE);
     table[0] = 0;

     for(int coin: coins){
         for(int i=coin; i< table.length; i++){
             int diff = i - coin;
             if(table[diff] != Integer.MAX_VALUE)
                 table[i] = Math.min(table[diff] +1 , table[i] );
         }
     }
     return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
 }


}
