package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**

  Given the root of a binary tree, return the preorder traversal of its nodes' values.
 
 
 
  Example 1:
 
 
  Input: root = [1,null,2,3]
  Output: [1,2,3]
  Example 2:
 
  Input: root = []
  Output: []
  Example 3:
 
  Input: root = [1]
  Output: [1]
  Example 4:
 
 
  Input: root = [1,2]
  Output: [1,2]
  Example 5:
 
 
  Input: root = [1,null,2]
  Output: [1,2]
 
 
  Constraints:
 
  The number of nodes in the tree is in the range [0, 100].
  -100 <= Node.val <= 100
 
 
  Follow up: Recursive solution is trivial, could you do it iteratively?
**/
public class Binary_Tree_Preorder_Traversal {

     /*   public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;
        result.add(root.val);

        if(root.left != null)
            result.addAll(preorderTraversal(root.left));
        if(root.right != null)
            result.addAll(preorderTraversal(root.right));
        return result;
    }

  */

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return result;
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
