package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class $105 {

    public static void main(String[] args) {
        var root = new Solution().buildTree(new int[]{4,9,20,15,7}, new int[]{9,4,15,20,7});
        System.out.println(root);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            if(n == 0) return null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, map, 0, n-1, 0, n-1);
        }

        private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map,
                                   int preOrderLeft, int preOrderRight,
                                   int inOrderLeft, int inOrderRight) {
            if(preOrderLeft > preOrderRight || preOrderLeft >= preorder.length) return null;
            TreeNode root = new TreeNode(preorder[preOrderLeft]);
            int inOrderRootIndex = map.get(preorder[preOrderLeft]);
            int leftLen = inOrderRootIndex - inOrderLeft;
            root.left = buildTree(preorder, map,
                    preOrderLeft + 1, preOrderLeft + leftLen ,
                    inOrderLeft, inOrderRootIndex - 1);
            root.right = buildTree(preorder, map,
                    preOrderLeft + leftLen + 1, preOrderRight,
                    inOrderRootIndex + 1, inOrderRight);
            return root;
        }
    }
}
