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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        return inorder(root, output);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> output) {
        if (root == null) {
            return output;
        }
        inorder(root.left, output);
        output.add(root.val);
        inorder(root.right, output);
        return output;
    }
}