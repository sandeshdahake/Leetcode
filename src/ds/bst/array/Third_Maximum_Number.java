package ds.bst.array;

/**
 * Given an integer ds.bst.array nums, return the third distinct maximum number in this ds.bst.array. If the third maximum does not exist, return the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Can you find an O(n) solution?
 */
public class Third_Maximum_Number {
    int thirdMax(int nums[]) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        boolean exists_min = false;
        for(int num : nums){
            if(num == Integer.MIN_VALUE) exists_min = true;
            if(num == max1 || num == max2 || num <= max3) continue;
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max3 = max2;
                max2 = num;
            }else{
                max3 = num;
            }
        }
        if(max2 == Integer.MIN_VALUE || max3 == Integer.MIN_VALUE && !exists_min)
            return max1;
        return max3;
    }
}
