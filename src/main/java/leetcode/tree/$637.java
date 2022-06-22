package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $637 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(new Solution().averageOfLevels(new TreeNode(3, left, right)));

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
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> ans = new ArrayList<>();
            if(root == null) {
                return ans;
            }
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                int length = size;
                double sum = 0;
                while(size > 0) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                    size--;
                }
                ans.add(sum/length);
            }
            return ans;
        }
    }
}
