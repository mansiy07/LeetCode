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
    int maxFreq = 0;
    int currFreq = 0;
    Integer prev = null;
    List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev == root.val) {
            currFreq++;
        } else {
            currFreq = 1;
        }
        if (currFreq > maxFreq) {
            maxFreq = currFreq;
            ans.clear();
            ans.add(root.val);
        }
        else if (currFreq == maxFreq) {
            ans.add(root.val);
        }
        prev = root.val;
        inorder(root.right);
    }
}