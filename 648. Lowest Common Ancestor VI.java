/*648. Lowest Common Ancestor VI
Medium
给定一个K叉树的根节点和一个节点列表，找出这些节点的最低公共祖先
Given M nodes in a K-nary tree, find their lowest common ancestor.

Assumptions

- M >= 2.

- There is no parent pointer for the nodes in the K-nary tree.

- The given M nodes are guaranteed to be in the K-nary tree.

Examples

        5

      /   \

     9   12

   / | \      \

  1 2 3     14



The lowest common ancestor of 2, 3, 14 is 5.

The lowest common ancestor of 2, 3, 9 is 9.

  */
/**
 * K叉树节点类
 */
public class KnaryTreeNode {
    int key; // 节点键值
    List<KnaryTreeNode> children; // 子节点列表

    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}

public class Solution {
    /**
     * 寻找K叉树中多个节点的最低公共祖先
     *
     * @param root  K叉树的根节点
     * @param nodes 需要寻找公共祖先的节点列表
     * @return 最低公共祖先节点
     */
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        Set<KnaryTreeNode> set = new HashSet<>();
        for (KnaryTreeNode node : nodes) {
            set.add(node); // 将目标节点添加到集合中
        }
        return solve(root, set);
    }

    /**
     * 递归解决最低公共祖先问题
     *
     * @param root K叉树的当前节点
     * @param set  目标节点集合
     * @return 最低公共祖先节点
     */
    private KnaryTreeNode solve(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        if (root == null || set.contains(root)) {
            return root; // 如果当前节点为空或在目标节点集合中，返回当前节点
        }

        KnaryTreeNode res = null; // 用于存储找到的公共祖先
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode subRes = solve(child, set); // 递归检查子节点
            if (subRes == null) {
                continue;
            }
            if (res == null) {
                res = subRes; // 找到第一个包含目标节点的子树
            } else {
                return root; // 如果找到多个子树包含目标节点，当前节点是最低公共祖先
            }
        }
        return res; // 返回找到的公共祖先
    }
}
