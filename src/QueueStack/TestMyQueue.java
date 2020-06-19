package QueueStack;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueueII q = new MyQueueII();

        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println("current size is " + q.size());

        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println("This poll should return null  " + q.poll());

        q.offer(4);
        q.offer(5);
        q.offer(6);
        System.out.println("This should be ok " + q.offer(7));
        System.out.println(q.offer(8));

        System.out.println("This should fail " + q.offer(9));

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll()); // 6

    }
}
