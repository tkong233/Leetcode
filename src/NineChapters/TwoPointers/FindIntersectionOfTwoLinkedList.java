package NineChapters.TwoPointers;
import LinkedList.ListNode;

public class FindIntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode A = headA;
        while (A != null && A.next != null) {
            A = A.next;
        }
        // A points to last node of list A
        A.next = headB;

        ListNode slow = headA;
        ListNode fast = headB;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        slow = headA;
        fast = fast.next;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        A.next = null;
        return slow;
    }
}
