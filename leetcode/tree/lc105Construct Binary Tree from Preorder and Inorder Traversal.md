```java
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

 // 1. 利用preorder找到root
 // 2. 构建root节点
 // 3. 找到左右子树的root，inorder的start与end，递归构建左右子树

 // base case
 // 对root进行操作
 // 递归左右子树
 // 返回

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length-1 || inStart > inEnd || inEnd > inorder.length-1) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int indexStart = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) indexStart = i;
        }
        
        root.left = helper(preStart+1, inStart, indexStart-1, preorder, inorder);
        root.right = helper(preStart+indexStart-inStart+1 ,indexStart+1, inEnd, preorder, inorder);
        return root;
    }
}