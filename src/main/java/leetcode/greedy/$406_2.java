package leetcode.greedy;

import java.util.Arrays;

public class $406_2 {

    public static void main(String[] args) {
        int[][] people = new int[][]{new int[]{7,0},
                new int[]{4,4},
                new int[]{7,1},
                new int[]{5,0},
                new int[]{6,1},
                new int[]{5,2}
        };
        int[][] results = new $406_2().reconstructQueue(people);
        System.out.println(Arrays.deepToString(results));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if(x[0] == y[0]) {
                return x[1] - y[1];
            }
            return y[0] - x[0];
        });
        for (int i = 1; i < people.length; i++) {
            int order = people[i][1];
            int height = people[i][0];
            int k = 0;
            while(order > 0) {
                if(people[k][0] >= height) {
                    order--;
                }
                k++;
            }
            if(k != i) {
                int[] cur = people[i];
                for(int j=i-1; j>=k; j--) {
                    int[] temp = people[j+1];
                    people[j+1] = people[j];
                    people[j] = temp;
                }
                people[k] = cur;
            }
        }
        return people;
    }

}
