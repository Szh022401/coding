504. Closest Number In Binary Search Tree II
Medium
In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array

Assumptions:

The given root is not null.
There are no duplicate keys in the binary search tree.
Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4

import java.util.ArrayDeque;
import java.util.Deque;

// Define the Solution class.
public class Solution {

    // Definition for binary tree node.
    public class TreeNode {
        public int key; // Node value
        public TreeNode left; // Pointer to left child
        public TreeNode right; // Pointer to right child

        // Constructor to create a new node with given key.
        public TreeNode(int key) {
            this.key = key;
        }
    }

    // Method to find the k values in the BST that are closest to the target.
    public int[] closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deq = new ArrayDeque<>(); // Use a deque to maintain the k closest values encountered so far.
        inorder(root, target, k, deq); // Perform in-order traversal of the tree to fill the deque.

        // Convert deque to array to return the result.
        int[] res = new int[deq.size()]; // Initialize the result array with the size of the deque.
        int i = 0; // Start with index 0.
        for (int num : deq) { // Iterate over each number in the deque.
            res[i++] = num; // Assign the number to the result array and increment the index.
        }
        return res; // Return the result array containing the k closest values.
    }

    // Helper method to perform in-order traversal of the BST.
    private void inorder(TreeNode root, double target, int k, Deque<Integer> deq) {
        if (root == null) {
            return; // Base case: if the node is null, return.
        }
        inorder(root.left, target, k, deq); // Recursively traverse the left subtree.

        // Check if the deque does not yet have k elements.
        if (deq.size() < k) {
            deq.offerLast(root.key); // Add current node's key to the deque.
        } else {
            // If deque has k elements, check if current node's key is closer to target than the first element in deque.
            if (Math.abs(root.key - target) < Math.abs(deq.peekFirst() - target)) {
                deq.pollFirst(); // Remove the first element from deque.
                deq.offerLast(root.key); // Add current node's key to the deque.
            } else {
                // If the current node's key is not closer to target, stop further traversal.
                return;
            }
        }

        inorder(root.right, target, k, deq); // Recursively traverse the right subtree.
    }
}
