package QueueStack;

// queue implementation using linked list

import LinkedList.ListNode;

public class MyQueueII {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyQueueII() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(int element) {
        ListNode newNode = new ListNode(element);

        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;

        return true;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }

        return head.value;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        node.next = null;
        size--;

        return node.value;
    }
}
