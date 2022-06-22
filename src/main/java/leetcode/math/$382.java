package leetcode.math;

import java.util.Random;

public class $382 {

    public static void main(String[] args) {

    }

    static class Solution {
        private ListNode head;
        private Random random;
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            for(ListNode node = head; node != null; node=node.next) {
                if(random.nextInt(i) == 0) {
                    ans = node.val;
                }
                i++;
            }
            return ans;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
