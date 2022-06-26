package leetcode.doublepointer;

public class $142_2 {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        node2.next = node1;
        System.out.println(new $142_2().detectCycle(node1));

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while(slow != fast);

        fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
        } while(slow != fast);
        return fast;

    }



    public static class ListNode {
       int val;
       ListNode next;
        public ListNode(int x) {
           val = x;
           next = null;
       }
       public ListNode(int x, ListNode next) {
           val = x;
           this.next = next;
       }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
