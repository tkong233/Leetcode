package QueueStack;

import java.util.*;

public class SortTwoStacks {

	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		if (s1 == null || s1.size() == 0) {
			return;
		}
		sort(s1, s2);
	}

	private void sort(Deque<Integer> input, Deque<Integer> buffer) {
		// step 1: sort at bottom of buffer in descending order, e.g. buffer [ 1, 2, 3, 4
		// step 2: move all sorted elements from buffer to input so they are in ascending order

		while (!input.isEmpty()) {
			int min = Integer.MAX_VALUE;
			int count = 0;

			// move all elements from input to buffer
			// find min and count
			while (!input.isEmpty()) {
				int val = input.pollFirst();
				if (val < min) {
					min = val;
					count = 1;
				} else if (val == min) {
					count += 1;
				}
				buffer.offerFirst(val);
			}

			// move all numbers != min from buffer back to input
			while (!buffer.isEmpty() && buffer.peekFirst() >= min) {
				int val = buffer.pollFirst();
				if (val != min) {
					input.offerFirst(val);
				}
			}

			// push min to buffer
			for (int i = 0; i < count; i++) {
				buffer.offerFirst(min);
			}
		}

		while (!buffer.isEmpty()) {
			int val = buffer.pollFirst();
			input.offerFirst(val);
		}

	}



	
	public static void main(String[] args) {
		
		LinkedList<Integer> s1 = new LinkedList<>();
		s1.offerFirst(1);
		s1.offerFirst(4);
		s1.offerFirst(6);
		s1.offerFirst(3);
		s1.offerFirst(7);
		s1.offerFirst(2);
		s1.offerFirst(3);

		SortTwoStacks solution = new SortTwoStacks();
		solution.sort(s1);


		while(!s1.isEmpty()) {
			System.out.println(s1.pollFirst());
		}
		
		
	}

}
