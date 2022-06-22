package leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class $1110 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);
        var ans = new Solution().delNodes(root, new int[]{3,5});
        System.out.println(ans);
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
        Set<Integer>  toDelete = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
            boolean flag = dfs(root);
            if(flag) {
                ans.add(root);
            }
            return ans;
        }

        boolean dfs(TreeNode node) {
            if(node == null) return false;
            boolean flag = toDelete.contains(node.val);
            if(!dfs(node.left)) {
                node.left = null;
            }else if(flag){
                ans.add(node.left);
            }
            if(!dfs(node.right)) {
                node.right = null;
            }else if(flag){
                ans.add(node.right);
            }
            return !flag;
        }
    }
}
