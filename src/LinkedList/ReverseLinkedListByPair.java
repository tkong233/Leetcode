package LinkedList;

public class ReverseLinkedListByPair {
    ListNode reversePair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 过去错误：两两反转其实大体顺序没变
        // 2 -> 1 -> newHead
        // recursion返回的newHead就是这一层的尾要连接的Node，这里和reverse linked list不一样

        ListNode newHead = reversePair(head.next.next);
        ListNode next = head.next;
        head.next = newHead;
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ReverseLinkedListByPair solution = new ReverseLinkedListByPair();
        ListNode result = solution.reversePair(ListNode.fromArray(new int [] {1, 2, 3, 4}));
        ListNode.printLinkedList(result);
    }
}
