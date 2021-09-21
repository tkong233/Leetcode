package Interviews.Databricks;
import java.util.*;

public class MergeIteratorII {
    Iterator<Integer> iter1;
    Iterator<Integer> iter2;
    PriorityQueue<Integer> minHeap;

    public MergeIteratorII(Iterator<Integer> iter1, Iterator<Integer> iter2) {
        this.iter1 = iter1;
        this.iter2 = iter2;
        minHeap = new PriorityQueue<>();
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        }
        if (!iter1.hasNext()) {
            return iter2.next();
        }
        if (!iter2.hasNext()) {
            return iter1.next();
        }
        minHeap.offer(iter1.next());
        while (iter2.hasNext()) {
            int next = iter2.next();
            minHeap.offer(next);
            if (next > minHeap.peek()) {
                break;
            }
        }
        return minHeap.poll();
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext() || !minHeap.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 6, 8, 10);
        List<Integer> list2 = Arrays.asList(0, 1, 2, 4, 5, 7, 8);
        Iterator iter1 = list1.iterator();
        Iterator iter2 = list2.iterator();

        MergeIteratorII iter = new MergeIteratorII(iter1, iter2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
