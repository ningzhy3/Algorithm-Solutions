# 二叉搜索树的第k小个节点

```java
TreeNode KthNode(TreeNode pRoot, int k) {
 inOrder(pRoot,0,k);
 return res;
}

public  void inOrder(TreeNode node, int count, int k) {
    if (node == null || count >= k) return;
    inOrder(node.left,count,k);
    count++;
    if (count == k)
        res = node;
    inOrder(node.right,count,k);
}
```

二叉搜索树当前节点总是大于左孩子小于右孩子，利用中序遍历可以遍历出顺序的特点进行中序遍历，同时保存一个count变量，每遍历到一个节点count++，直到k==count，找出第k小的节点。