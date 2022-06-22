package leetcode.tree;

import leetcode.Tests;

public class $110 {

    public static void main(String[] args) {
        TreeNode nodeLeft3 = new TreeNode(3,
                new TreeNode(4, null, null), new TreeNode(4, null, null));
        TreeNode nodeLeft2 = new TreeNode(2, nodeLeft3, new TreeNode(3, null, null));
        TreeNode root = new TreeNode(1, nodeLeft2, new TreeNode(2, null, null));
        System.out.println(new Solution().isBalanced(root));

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
        public boolean isBalanced(TreeNode root) {
            int depth = depth(root);
            return depth != -1;
        }


        private int depth(TreeNode node) {
            if(node == null) {
                return 0;
            }
            int l = depth(node.left), r = depth(node.right);
            if(l == -1 || r == -1 || Math.abs(l - r) > 1) {
                return -1;
            }
            return Math.max(l, r) + 1;
        }
    }
}
