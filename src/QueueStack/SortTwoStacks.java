package QueueStack;

import java.util.LinkedList;

public class SortTwoStacks {
	
	public static LinkedList<Integer> sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();

		while (!s1.isEmpty()) {
			sort(s1, s2);
		}

		s1 = s2;
		return s1;

	}

	private static void sort(LinkedList<Integer> s1, LinkedList<Integer> s2) {
		int min = Integer.MAX_VALUE;
		int count = 0;

		while (!s1.isEmpty()) {
			int s = s1.pollFirst();
			if (s < min) {
				min = s;
				count = 1;
			} else if (s == min) {
				count += 1;
			}
			s2.offerFirst(s);
		}

		while (!s2.isEmpty() && s2.peekFirst() >= min) {
			int a = s2.pollFirst();
			if (a != min) {
				s1.offerFirst(a);
			}
		}

		for (int i = 0; i < count; i++) {
			s2.offerFirst(min);
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> s1 = new LinkedList<>();
		s1.offerFirst(1);
		s1.offerFirst(4);
		s1.offerFirst(6);
		s1.offerFirst(5);
		s1.offerFirst(7);
		s1.offerFirst(2);
		s1.offerFirst(3);
		
		sort(s1);
		

		while(!s1.isEmpty()) {
			System.out.println(s1.pollFirst());
		}
		
		
	}

}
