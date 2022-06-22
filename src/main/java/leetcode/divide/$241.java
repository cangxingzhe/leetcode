package leetcode.divide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $241 {
    public static void main(String[] args) {
        System.out.println(new $241().diffWaysToCompute2("2-1-1"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1));
                for (Integer l : lefts) {
                    for (Integer r : rights) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }

        }
        if(ways.isEmpty()) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }


    Map<String, List<Integer>> map = new HashMap<>();
    // divide + memoization
    public List<Integer> diffWaysToCompute2(String input) {
        if(map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1));
                for (Integer l : lefts) {
                    for (Integer r : rights) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }

        }
        if(ways.isEmpty()) {
            ways.add(Integer.valueOf(input));
        }
        map.put(input, ways);
        return ways;
    }

    // dp
    public List<Integer> diffWaysToCompute3(String input) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        char[] array = input.toCharArray();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (isOperation(array[i])) {
                numList.add(num);
                num = 0;
                opList.add(array[i]);
                continue;
            }
            num = num * 10 + array[i] - '0';
        }
        numList.add(num);
        int N = numList.size(); // 数字的个数
        // 含义是第 i 到第 j 个数字（从 0 开始计数）范围内的表达式的所有解。
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];

        // 两部分之间的运算符的话，因为表达式是一个数字一个运算符，所以运算符的下标就是左部分最后一个数字的下标。
        // 只有一个数字
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(numList.get(i));
            dp[i][i] = result;
        }
        // 2 个数字到 N 个数字
        for (int n = 2; n <= N; n++) {
            // 开始下标
            for (int i = 0; i < N; i++) {
                // 结束下标
                int j = i + n - 1;
                if (j >= N) {
                    break;
                }
                ArrayList<Integer> result = new ArrayList<>();
                // 分成 i ~ s 和 s+1 ~ j 两部分
                for (int s = i; s < j; s++) {
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for (Integer integer : result1) {
                        for (Integer value : result2) {
                            // 第 s 个数字下标对应是第 s 个运算符
                            char op = opList.get(s);
                            result.add(caculate(integer, op, value));
                        }
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[0][N-1];

    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
