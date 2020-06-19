package QueueStack;
// queue implementation using circular array


// method 1. maintain a size field.
// method 2. head + 1 == tail => full
//           head == tail => empty
public class MyQueue {
    private int[] array;
    private int size;
    private int head;
    private int tail;

    // range = [head, tail)

    public MyQueue(int capacity) {
        array = new int[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return array[head];
    }

    public boolean offer(int element) {
        if (size >= array.length) {
            return false;
        }

        array[tail] = element;
        tail = tail + 1 == array.length ? 0 : tail + 1;

        size++;

        return true;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }

        int element = array[head];
        head = head + 1 == array.length ? 0 : head + 1;

        size--;

        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int size() {
        return size;
    }
}
