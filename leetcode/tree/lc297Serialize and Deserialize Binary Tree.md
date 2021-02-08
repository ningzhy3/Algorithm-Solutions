```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // use preorder traversal to implement
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper1(root, "");
    }
    
    public String helper1(TreeNode root, String s) {
        if (root == null) s += "null,";
        else {
            s += root.val + ",";
            s = helper1(root.left, s);
            s = helper1(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList(Arrays.asList(strs));
        return helper2(list);
    }

    public TreeNode helper2(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = helper2(list);
        root.right = helper2(list);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));