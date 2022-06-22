package leetcode.tree;

public class $572 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                null);
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        //System.out.println(new Solution().isSubtree(root, subRoot));
        System.out.println(new Solution().isSubtree(new TreeNode(1, new TreeNode(1), null), new TreeNode(1)));

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null && subRoot == null) return true;
            if(root == null || subRoot == null) return false;
            /*if(dfs(root, subRoot)) return true;
            return dfs(root.left, subRoot) || dfs(root.right, subRoot);*/

             return dfs2(root, subRoot);
        }

        private boolean dfs2(TreeNode root, TreeNode subRoot) {
            if(root == null) return false;
            if(dfs(root, subRoot)) return true;
            return dfs2(root.left, subRoot) || dfs2(root.right, subRoot);

        }

        private boolean dfs(TreeNode root, TreeNode subRoot) {
            if(root == null && subRoot == null) return true;
            if(root == null || subRoot == null) return false;
            if(root.val != subRoot.val) {
                return false;
            };
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
    }
}
