/**
https://leetcode.com/problems/binary-tree-cameras/
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0

**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class BinaryTreeCameras {
    int numberOfCameras=0;
    //1->node covered
    //0->camera present at that node
    //-1->needed camera
    public int minCameraCover(TreeNode root) {
        int rootType= nodeType(root);
        if(rootType==-1)
            numberOfCameras++;
        return numberOfCameras;
    }
    public int nodeType(TreeNode root)
    {
        if(root==null)  //I am the leaf node and I am always covered
            return 1;
        int left= nodeType(root.left);
        int right=nodeType(root.right);
        if(left==-1 || right==-1) //My children have child and i am not covered , install camera
        {
            numberOfCameras++;
            return 0;
        }
        if(left==0 || right==0) //My children covers me
            return 1;
        return -1;       
    }
}
