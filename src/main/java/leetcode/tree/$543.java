package leetcode.tree;

public class $543 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode root = new TreeNode(1, left, new TreeNode(3));
        System.out.println(new Solution().diameterOfBinaryTree(root));
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
        int diameter;
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return diameter;
        }

        private int helper(TreeNode node) {
            if(node == null) return 0;
            int l = helper(node.left), r = helper(node.right);
            diameter = Math.max(l+r, diameter);
            return Math.max(l, r) + 1;
        }
    }
}
