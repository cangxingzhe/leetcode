package leetcode.tree;

public class $226 {

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
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return null;
            }
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if(root == null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null) dfs(root.left);
            if(root.right != null) dfs(root.right);
        }
    }
}
