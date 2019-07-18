package LinkedList;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null && head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.println(head.value);
        }
    }
}
