package tree;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
