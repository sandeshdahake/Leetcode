package algo;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * Pairs of Songs With Total Durations Divisible by 60
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * Constraints:
 *
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/1661825/Group-values-with-same-modulus-into-buckets-and-count-pair
 */
public class Pairs_Songs_Total_Durations_div_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int [] modulus = new int[60];

        for(int t : time){
            modulus[t%60]++;
        }

        // base cases
        int total = getPair(modulus[0]) + getPair(modulus[30]);
        for(int i = 1; i < 30; i++){
            total += modulus[i] * modulus[60 - i];
        }
        return total;
    }

    private int getPair(int n) {
        return n * (n - 1) / 2;
    }
}
