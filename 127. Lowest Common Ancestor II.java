/*
127. Lowest Common Ancestor II
Medium
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

题目说明："127. 最低公共祖先 II"（中等难度）：给定一个带有父指针的二叉树中的两个节点，找到它们的最低公共祖先。

假设：

二叉树中的节点都有父指针。
给定的两个节点不一定保证都在二叉树中。
示例：

markdown
Copy code
        5
      /   \
     9     12
   /  \      \
  2    3      14
2和14的最低公共祖先是5。
2和9的最低公共祖先是9。
2和8的最低公共祖先是null（8不在树中）。
代码注解：

TreeNodeP 类：定义了带有父指针的树节点。
lowestCommonAncestor(TreeNodeP one, TreeNodeP two) 方法：找到两个节点的最低公共祖先。
计算两个节点到根节点的路径长度。
将较长路径的节点向上移动，直到两路径长度相同。
同时向上遍历两个节点，直到找到共同的祖先节点。
goUp(TreeNodeP longer, TreeNodeP shorter, int diff) 方法：将较长的路径上的节点向上移动diff个级别。
length(TreeNodeP node) 方法：计算从给定节点到根节点的路径长度。
*/


/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    int lenone = length(one);
    int lentwo = length(two);
    if(lenone >= lentwo){
      return goUp(one,two,lenone - lentwo);
    }else{
      return goUp(two,one,lentwo - lenone);
    }

  }
  private TreeNodeP goUp(TreeNodeP longer,TreeNodeP shorter,int diff){
    while(diff > 0){
      longer = longer.parent;
      --diff ;
    }
    while(shorter != longer){
        longer = longer.parent;
        shorter = shorter.parent;
    }
    return shorter;
  }
  private int length(TreeNodeP node){
    int size = 0;
    while(node != null){
      node = node.parent;
      size ++;
    }
    return size;
  }
}
