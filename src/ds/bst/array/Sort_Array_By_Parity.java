package ds.bst.array;
/**
* Given an integer ds.bst.array nums, move all the even integers at the beginning of the ds.bst.array followed by all the odd integers.
*
*Return any ds.bst.array that satisfies this condition.
*
* 
*
*Example 1:
*
*Input: nums = [3,1,2,4]
*Output: [2,4,3,1]
*Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*Example 2:
*
*Input: nums = [0]
*Output: [0]
* 
*
*Constraints:
*
*1 <= nums.length <= 5000
*0 <= nums[i] <= 5000
*/

class Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] nums) {
        
        if(nums.length == 1){
            return nums;
        }
        
        int maxIndex = nums.length-1; 
        int i=0;
        
        for(int j=0; j<= maxIndex; j++){
            int temp; 
            if(nums[j] % 2 == 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp; 
                i++;
            }
        }
        
       return nums; 
    }
}
