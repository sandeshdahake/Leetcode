package algo.dp; 
//https://leetcode.com/problems/house-robber-ii/
// Same as house robber 1 but here the houses are connected in circle hence we can not rob 1st and last house together. Break the array in two parts one starting with 0 index and ends 
// at length - 2 index ( second last element) and other array starting at 1 and ending at last house ( n-1 ) . Find the max of both

class House_Robber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        
        if(nums.length == 1) return nums[0];
        
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i< nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
}
