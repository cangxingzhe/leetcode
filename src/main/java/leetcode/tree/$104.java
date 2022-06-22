package leetcode.tree;

public class $104 {

    public static void main(String[] args) {
        TreeNode node20 = new TreeNode(20,
                new TreeNode(15, null, null),
                new TreeNode(7, null, null));
        TreeNode root = new TreeNode(2, new TreeNode(9, null, null), node20);
        System.out.println(new Solution().maxDepth(root));
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
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;

            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return Math.max(l, r) + 1;
        }
    }
}
