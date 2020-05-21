package LinkedList;

public class ReverseLinkedListRecursive {
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        // 过去错误：这里不能用newHead.next = head!!!
        // newHead是reverse后的子问题的头，而这里我们是要把子问题的尾接到head上
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedListRecursive solution = new ReverseLinkedListRecursive();
        ListNode result = solution.reverse(ListNode.fromArray(new int[] {0, 1, 2, 3}));
        ListNode.printLinkedList(result);
    }
}
