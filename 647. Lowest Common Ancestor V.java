
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


public class Solution {
    // K 叉树节点的定义。
    public class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;
        
        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }

    // 主方法用于找到两个节点的最低公共祖先。
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // 基本情况：如果当前节点是 null 或者是目标节点之一，返回当前节点。
        if (root == null || root == a || root == b) {
            return root;
        }

        // 初始化用于存储找到的子结果的变量。
        KnaryTreeNode res = null;

        // 遍历当前节点的所有子节点。
        for (KnaryTreeNode child : root.children) {
            // 递归在子树中寻找最低公共祖先。
            KnaryTreeNode subRes = lowestCommonAncestor(child, a, b);

            // 如果子树中没有找到目标节点，继续检查下一个子节点。
            if (subRes == null) {
                continue;
            }

            // 如果这是第一次找到目标节点，保存结果。
            if (res == null) {
                res = subRes;
            } else {
                // 如果之前已经找到过一个目标节点，那么当前节点就是最低公共祖先。
                return root;
            }
        }
        // 返回找到的最低公共祖先。
        return res;
    }
}
