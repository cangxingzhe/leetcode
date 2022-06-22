package practice;

import java.util.LinkedList;
import java.util.Stack;

public class Demo5 {

    public static void main(String[] args) {
        LinkedList<Integer> source = new LinkedList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);
        source.add(6);
        doIt(source, 3);
    }

    private static void doIt(LinkedList<Integer> source, int k) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (Integer integer : source) {
            count++;
            stack.push(integer);
            if(count == k) {
                count = 0;
                for (int i = 0; i < k; i++) {
                    System.out.print(stack.pop());
                }
                stack = new Stack<>();
            }
        }
    }
}
