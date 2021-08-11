package LinkedList;

public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddleNode(head);
        ListNode first = head;
        ListNode second = middle.next;
        middle.next = null;
        second = reverse(second);
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (first != null && second != null) {
            cur.next = first;
            first = first.next;
            cur.next.next = second;
            second = second.next;
            cur = cur.next.next;
        }
        if (first != null) {
            cur.next = first;
        }
        return dummyHead.next;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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
        ReorderLinkedList solution = new ReorderLinkedList();
        ListNode head = ListNode.fromArray(new int[] {1, 2, 3, 4});
        solution.reorder(head);
        ListNode.printLinkedList(head);
    }
}
