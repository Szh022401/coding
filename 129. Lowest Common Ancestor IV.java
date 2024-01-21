129. Lowest Common Ancestor IV
Hard
Given K nodes in a binary tree, find their lowest common ancestor.

Assumptions

K >= 2

There is no parent pointer for the nodes in the binary tree

The given K nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2, 3, 14 is 5

The lowest common ancestor of 2, 3, 9 is 9

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // Write your solution here.
    Set <TreeNode> set = new HashSet<>();
    
    for(TreeNode num: nodes){
      set.add(num);
    }
    return Solve(root,nodes,set);
  }
  private TreeNode Solve(TreeNode root, List<TreeNode> nodes,Set <TreeNode> set){
    // Base case: return the root if it's null or if it's one of the target nodes.
    if(root == null || set.contains(root)){
      return root;
    }
    TreeNode left = Solve(root.left,nodes,set);
    TreeNode right = Solve(root.right,nodes,set);
    // If both left and right subtrees return a non-null value,
    // it means the current root is the LCA.
    if(left!= null && right != null){
      return root;
    }else if(left == null && right == null){
      return null;
    }
    // If only one of left or right is non-null, return the non-null value.
    return left != null ? left : right;
  }
  
}
