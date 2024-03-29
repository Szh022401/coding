126. Lowest Common Ancestor I
Medium
Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

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

base case: root == a  root == b root == null -> return root
generalcase: c
case 0 ：left== null && right == null -> return null
case 1:left != nul1 && right != null -> return root
case 2: left == null && right != null -> return right
case 3: left != nul1 && right == null -> return Ieft
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode a, TreeNode b) {
    // Write your solution here.
   // case 0
    if (root == null || root == a || root == b) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left,a,b);
    TreeNode right = lowestCommonAncestor(root.right,a,b);
   //case  1
    if(left != null && right !=null){
      return root;
    }//case 0 else if(left == null && right == null){
      return null;
    }//这个可以不写 因为下面的已经判断了 如果 和left都是，right则null函数将到达最终的返回语句：return left != null ? left : right;。既然left是null，就会返回right，这是也null。因此，null无论如何它都会有效地返回
    //case  2 3
    return left != null ? left : right;//
  }
}
