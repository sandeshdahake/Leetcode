package algo.dp; 
//https://leetcode.com/problems/house-robber-ii/
// Same as house robber 1 but here the houses are connected in circle hence we can not rob 1st and last house together. Break the array in two parts one starting with 0 index and ends 
// at length - 2 index ( second last element) and other array starting at 1 and ending at last house ( n-1 ) . Find the max of both

class House_Robber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        
        if(nums.length == 1) return nums[0]; 
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int rob1 = letsRob(nums, 0, nums.length -2); 
        int rob2 = letsRob(nums, 1, nums.length -1); 
        
        return Math.max(rob1, rob2); 
    }
    
    private int letsRob(int[] nums, int startIndex, int lastIndex){
        
        int[] table = new int[nums.length];
        table[startIndex] = nums[startIndex]; 
        table[startIndex+1] = Math.max(nums[startIndex], nums[startIndex+1]);
        for(int i= startIndex+2; i<= lastIndex; i++){
          table[i] = Math.max(table[i-1], table[i-2] + nums[i]);    
        }
        return table[lastIndex]; 
    }
}
