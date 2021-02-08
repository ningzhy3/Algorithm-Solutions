```java
//
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
    // 初始值
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }


    public int helper(TreeNode node) {
        // base case
        if (node == null) return 0;
        // 递归
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        // 构造返回值
        // 需要计算的结果不一定与返回值相同
        int sum = node.val+left+right;
        res = Math.max(res, sum);
        return node.val + Math.max(left, right);
        
    } 
}