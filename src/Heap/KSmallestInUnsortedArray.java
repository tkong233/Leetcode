package Heap;

import java.util.*;

public class KSmallestInUnsortedArray {
    // way 1: use a min heap
//    int[] kSmallest(int[] input, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue();
//        for (int i = 0; i < input.length; i++) {
//            minHeap.offer(input[i]);
//        }
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = minHeap.poll();
//        }
//        return result;
//    }

    // way 2: use a max heap
    int[] kSmallest(int[] input, int k) {
        if (k == 0 || input == null) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1.equals(i2)) {
                    return 0;
                }
                return i1 < i2 ? 1 : -1;
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < maxHeap.peek()) {
                // 如果新元素比heap top要小，则*替换*top元素（需要把原来的top给poll出来）
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

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
    public int[] kSmallest1(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        ArrayList<MyInteger> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new MyInteger(array[i]));
        }
        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>(list);
        for (int i = k; i < array.length; i++) {
            if (maxHeap.peek().value > array[i]) {
                maxHeap.poll();
                maxHeap.offer(new MyInteger(array[i]));
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll().value;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[] {1, 4, 9, 2, 3, 4, 0, 12, 15};
        KSmallestInUnsortedArray solution = new KSmallestInUnsortedArray();
        int[] result = solution.kSmallest1(input, 3);
        System.out.println(Arrays.toString(result));
    }
}
