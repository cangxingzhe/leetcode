package leetcode.tree;

public class $99 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        new Solution().recoverTree(root);
        System.out.println();
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
        TreeNode mistake1 = null;
        TreeNode mistake2 = null;
        TreeNode preNode = null;
        public void recoverTree(TreeNode root) {
            inOrder(root);
            swap(mistake1, mistake2);
        }

        private void swap(TreeNode mistake1, TreeNode mistake2) {
            if(mistake1 != null && mistake2 != null ) {
                int temp = mistake1.val;
                mistake1.val = mistake2.val;
                mistake2.val = temp;
            }
        }

        private void inOrder(TreeNode node) {
            if(node == null) return;
            if(node.left != null) {
                inOrder(node.left);
            }
            if(preNode != null) {
                if(node.val < preNode.val) {
                    if(mistake1 == null) {
                        mistake1 = preNode;
                        mistake2 = node;
                    }else {
                        mistake2 = node;
                    }
                }
            }
            preNode = node;
            if(node.right != null) {
                inOrder(node.right);
            }
        }
    }


}
