package LinkedList;

import java.util.LinkedList;

public class ReverseLinkedListIterative {
    ListNode reverse(ListNode head) {
        // 反转时，是反转cur和prev之间的箭头，并且把next记下来。
        // 不是反转cur和next之间的！！
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListIterative solution = new ReverseLinkedListIterative();
        ListNode result = solution.reverse(ListNode.fromArray(new int[] {0, 1, 2, 3}));
        ListNode.printLinkedList(result);
    }
}
