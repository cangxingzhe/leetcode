package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class $513 {

    public static void main(String[] args) {
        /*System.out.println(new Solution()
                .findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3))));*/
        System.out.println(new Solution()
                .findBottomLeftValue(new TreeNode(0, null, new TreeNode(-1))));

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
        public int findBottomLeftValue(TreeNode root) {
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                boolean first = false;
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    if(!first) {
                        ans = node.val;
                        first = true;
                    }
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
            }
            return ans;
        }
    }
}
