package tree;
//https://leetcode.com/problems/path-sum/
class Path_Sum{
  
  public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        } else if(root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
