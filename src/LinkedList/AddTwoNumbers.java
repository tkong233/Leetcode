/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 */

package LinkedList;
public class AddTwoNumbers {
    public static void main(String args[]) {
        ListNode l1 = ListNode.fromArray(new int[] {1, 6, 5});
        ListNode l2 = ListNode.fromArray(new int[] {6, 3, 6, 2});
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        ListNode.printLinkedList(result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int val = 0;
        while (l1 != null || l2 != null || val != 0) {
            if (l1 != null) {
                val += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.value;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            val /= 10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
