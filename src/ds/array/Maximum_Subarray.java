package ds.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  Time : O(N) , Space = O(1)
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int sum=0;
        int max= Integer.MIN_VALUE;

        for(int num: nums) {
            sum += num;
            max = Math.max(max,sum);
            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}

/**

 [-2,1,-3,4,-1,2,1,-5,4]

 sum = 0  max = Integer.MIN_VALUE

 sum = 0 + -2 = -2    |   Max = -2  =>  Sum = 0
 sum = 0 + 1 = 1 | max = sum, max - 1  => 1
 sum = -2  max = 1
 sum = 4.  max 4
 sum = 3.  max 4
 sum = 5.  max 5
 sum = 6.  max = 6
 sum = 1. max = 6
 sum = 5. sum = 6
Catch is negative values :  if sum is negative make it 0
 */