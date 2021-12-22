package ds.bst.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://medium.com/@saurav.agg19/find-all-numbers-disappeared-in-an-array-c6a01393909
 * Given an ds.bst.array nums of n integers where nums[i] is in the range [1, n], return an ds.bst.array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 *    Hide Hint #1
 * This is a really easy problem if you decide to use additional memory. For those trying to write an initial solution using additional memory, think counters!
 *    Hide Hint #2
 * However, the trick really is to not use any additional space than what is already available to use. Sometimes, multiple passes over the input ds.bst.array help find the solution. However, there's an interesting piece of information in this problem that makes it easy to re-use the input ds.bst.array itself for the solution.
 *    Hide Hint #3
 * The problem specifies that the numbers in the ds.bst.array will be in the range [1, n] where n is the number of elements in the ds.bst.array. Can we use this information and modify the ds.bst.array in-place somehow to find what we need?
 */
public class All_Numbers_Disappeared_in_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
