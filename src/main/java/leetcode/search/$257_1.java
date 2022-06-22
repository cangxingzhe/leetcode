package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class $257_1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)),
                new TreeNode(3, null, null));
        System.out.println(new $257_1().binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new ArrayList<>();
        List<String> results = new ArrayList<>();
        paths.add(root.val);
        backtracking(root, results, paths);
        return results;
    }

    public void backtracking(TreeNode root, List<String> results, List<Integer> paths) {
        if(root.left == null && root.right == null) {
            StringBuilder pathAppend = new StringBuilder();
            for (Integer path : paths) {
                pathAppend.append(path).append("->");
            }
            results.add(pathAppend.substring(0, pathAppend.length()-2));
            return;
        }

        if(root.left != null) {
            paths.add(root.left.val);
            backtracking(root.left, results, paths);
            paths.remove(paths.size() - 1);
        }
        if(root.right != null) {
            paths.add(root.right.val);
            backtracking(root.right, results, paths);
            paths.remove(paths.size() - 1);
        }
    }

    public static class TreeNode {
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
}
