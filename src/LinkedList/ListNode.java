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

    public static ListNode fromArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length; i++) {
            ListNode next = new ListNode(array[i]);
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }
}
