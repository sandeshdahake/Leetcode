package ds.bst.array;
/**
* Given an integer ds.bst.array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* 
* Note that you must do this in-place without making a copy of the ds.bst.array.
* 
* 
* 
* Example 1:
* 
* Input: nums = [0,1,0,3,12]
* Output: [1,3,12,0,0]
* Example 2:
* 
* Input: nums = [0]
* Output: [0]
*  
* 
* Constraints:
* 
* 1 <= nums.length <= 104
* -231 <= nums[i] <= 231 - 1
*  
* 
* Follow up: Could you minimize the total number of operations done?
*/ 
class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        
        int maxIndex = nums.length -1; 
        
        int i= 0; 
        
        for(int j=0; j<= maxIndex; j++){
            int temp; 
            if(nums[j] != 0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }     
}

