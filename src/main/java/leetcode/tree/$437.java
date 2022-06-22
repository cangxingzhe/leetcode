package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class $437 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5,
                new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                new TreeNode(2, null ,new TreeNode(1)));
        TreeNode right = new TreeNode(-3, null, new TreeNode(11));
        TreeNode root = new TreeNode(10, left, right);
        System.out.println(new Solution2().pathSum(root, 8));
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
        private int ans;
        private int targetSum;
        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            dfs1(root);
            return ans;
        }

        private void dfs1(TreeNode node) {
            if(node == null) return;
            dfs2(node, node.val);
            dfs1(node.left);
            dfs1(node.right);
        }

        private void dfs2(TreeNode node, int val) {
            if(val == targetSum) ans++;
            if(node.left != null) dfs2(node.left, node.left.val + val);
            if(node.right != null) dfs2(node.right, node.right.val + val);
        }
    }

    static class Solution2 {
        private int ans;
        private int targetSum;
        private Map<Integer, Integer> map = new HashMap<>();
        public int pathSum(TreeNode root, int targetSum) {
            if(root == null) {
                return ans;
            }
            this.targetSum = targetSum;
            map.put(0, 1);
            dfs(root, root.val);
            return ans;
        }

        private void dfs(TreeNode root, int val) {
            if(map.containsKey(val - targetSum)) ans += map.get(val - targetSum);
            map.put(val, map.getOrDefault(val, 0) + 1);
            if(root.left != null) dfs(root.left, val + root.left.val);
            if(root.right != null) dfs(root.right, val + root.right.val);
            map.put(val, map.getOrDefault(val, 0) + -1);
        }

    }
}
