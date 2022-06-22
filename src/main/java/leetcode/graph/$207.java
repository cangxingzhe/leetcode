package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $207 {

    public static void main(String[] args) {
        System.out.println(new $207().canFinish(2, new int[][]{new int[]{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int i = queue.poll();
            ans[index++]  = i;
            for (Integer j : edges.get(i)) {
                inDegrees[j]--;
                if(inDegrees[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        return index == numCourses;
    }
}
