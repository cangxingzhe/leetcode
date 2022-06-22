package leetcode.doublepointer;

public class $142 {

    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
