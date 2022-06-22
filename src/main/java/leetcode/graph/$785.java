package leetcode.graph;

import java.util.Arrays;

public class $785 {

    public static void main(String[] args) {
        int[][] graph = new int[][]
                {
                        new int[]{1, 2, 3},
                        new int[]{0, 2},
                        new int[]{0, 1, 3},
                        new int[]{0, 2}
                };
        System.out.println(new $785().isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {  // 处理图不是连通的情况
            if (colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!isBipartite(nextNode, 1 - curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}
