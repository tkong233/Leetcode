package Interviews.Intuit;
import java.util.*;

public class Ab_FindMidCourse {
    /*
        给出一些课程和课程的先修课，每个课程有且只有一门先修课，
        并且保证学生只有一条path修完所有课程，求修到一半时的课程名称。

        例如，输入{{A, B}, {C, D}, {B, C}, {E, F}, {D, E}, {F, G}}, 输出 D.
     */

    class ListNode {
        char value;
        ListNode next;

        public ListNode(char value) {
            this.value = value;
        }
    }

    char findMidCourse(List<List<Character>> courses) {
        Map<Character, ListNode> map = new HashMap<>();
        ListNode dummyHead = new ListNode(' ');

        for (List<Character> course : courses) {
            char pre = course.get(0);
            char cur = course.get(1);

            ListNode preNode = map.containsKey(pre) ? map.get(pre) : new ListNode(pre);
            ListNode curNode = map.containsKey(cur) ? map.get(cur) : new ListNode(cur);
            map.put(pre, preNode);
            map.put(cur, curNode);

            preNode.next = curNode;
            if (dummyHead.next == null || dummyHead.next == curNode) {
                dummyHead.next = preNode;
            }
        }

        ListNode mid = findMidNode(dummyHead.next);
        return mid.value;
    }

    ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Ab_FindMidCourse solution = new Ab_FindMidCourse();
        List<List<Character>> courses = new LinkedList<>();
        List<Character> c1 = Arrays.asList('A', 'B');
        List<Character> c2 = Arrays.asList('C', 'D');
        List<Character> c3 = Arrays.asList('B', 'C');
        List<Character> c4 = Arrays.asList('E', 'F');
        List<Character> c5 = Arrays.asList('F', 'G');
        List<Character> c6 = Arrays.asList('D', 'E');
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);
        courses.add(c6);

        char mid = solution.findMidCourse(courses);
        System.out.println(mid);
    }
}
