package leetcode.tree;

public class $617 {

    public static void main(String[] args) {

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return  dfs(root1, root2);
        }

        private TreeNode dfs(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null) {
                return null;
            }
            TreeNode node = new TreeNode();
            if(root1 != null && root2 == null) {
                node.val = root1.val;
                node.left = dfs(root1.left, null);
                node.right = dfs(root1.right, null);

            } else if(root1 == null) {
                node.val = root2.val;
                node.left = dfs(root2.left, null);
                node.right = dfs(root2.right, null);
            } else {
                node.val = root1.val + root2.val;
                node.left = dfs(root1.left, root2.left);
                node.right = dfs(root1.right, root2.right);
            }
            return node;
        }
    }
}
