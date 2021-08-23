package Heap;
import java.util.*;

public class KLargest {
    class MyInteger implements Comparable<MyInteger> {
        int value;
        public MyInteger(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyInteger other) {
            if (this.value == other.value) {
                return 0;
            }
            return this.value > other.value ? -1 : 1;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        List<KLargest.MyInteger> list = new ArrayList<>();
        for (int i : nums) {
            list.add(new MyInteger(i));
        }
        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>(list);
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll().value;
    }

    public static void main(String[] args) {
        KLargest solution = new KLargest();
        int result = solution.findKthLargest(new int[] {1, 2, 3, 4}, 2);
        System.out.println(result);
    }
}
