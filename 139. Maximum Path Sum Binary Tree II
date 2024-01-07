139. Maximum Path Sum Binary Tree II
Hard
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

​The root of the given binary tree is not null
Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2
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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
// 初始化一个数组存储结果，初始值为最小整数，以处理所有节点值都是负数的情况
    int [] ans = new int[]{Integer.MIN_VALUE};
    help(root,ans);
    return ans[0];
  }
  private int help(TreeNode root ,int [] ans){
    if(root == null){
      return 0;
    }
    int left = help(root.left,ans);
    int right = help(root.right,ans);
// 如果左/右子树提供的路径和为负数，则不考虑该子树（因为可以选择不走这条路径）
    left = left < 0 ? 0 : left; // 小于0 不要
    right = right < 0 ? 0 : right; // 小于0 不要
 // 计算通过当前节点的最大路径和（左子树+当前节点+右子树）
    int cur  = root.key + left + right;// 就是 直上 下 + 自己 想个人字形的 加法
    ans[0] = Math.max(cur,ans[0]);//更新最大值
// 返回当前节点加上左右子树中较大的那一个的和（只能选择一边，因为路径是单向的）
    return root.key + Math.max(left , right);// 返回 自己 加上左右的最大值
  }
}
