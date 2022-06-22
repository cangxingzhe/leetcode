package leetcode.tree;

public class $404 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfLeftLeaves(
                new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
                )));
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
        int sum ;
        public int sumOfLeftLeaves(TreeNode root) {
            dfs(root, false);
            return sum;
        }

        private void dfs(TreeNode root, boolean isLeft) {
            if(root == null) return;
            if(root.left == null && root.right == null && isLeft) {
                sum += root.val;
            }
            if(root.left != null)  dfs(root.left, true);
            if(root.right != null)  dfs(root.right, false);

        }
    }
}
