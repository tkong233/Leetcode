package Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
	private int[] array;
	private int size;
	
	public MinHeap(int[] array) {
		if(array == null || array.length == 0) {
			throw new IllegalArgumentException("input can not be null or empty");
		}
		else {
			this.array = array;
			this.size = array.length;
			heapify();
		}
	}
	
	public MinHeap(int cap) {
		if(cap <= 0) {
			throw new IllegalArgumentException("capacity can not be negative or 0");
		}
		else {
			array = new int[cap];
			size = 0;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}	
	public void percolateDown(int index) {
		while(index * 2 + 1 < size) {
			int leftChild = index * 2 + 1;
			int rightChild = index * 2 + 2;
			int swapCandidate = leftChild;
			if(rightChild < size && array[rightChild] < array[leftChild]) {
				swapCandidate = rightChild;
			}
			if(array[index] > array[swapCandidate]) {
				swap(index, swapCandidate);
			}
			else {
				break;
			}
			index = swapCandidate;
		}
	}
	
	public void percolateUp(int index) {
		while(index > 0 && index < size - 1) {
			int parent = (index - 1) / 2;
			if(array[parent] > array[index]) {
				swap(parent, index);
			}
			else {
				break;
			}
			index = parent;
		}
	}
	
	public void heapify() {
		for(int i = (size-1)/2; i >= 0; i--) {
			percolateDown(i);
		}
	}
	
	public int peek(int index) {
		if(index > 0 && index < array.length) {
			return array[index];
		}
		else {
			throw new IllegalArgumentException("Array index out of bound");
		}
	}
	
	public int poll() {
		if(size <= 0) {
			throw new NoSuchElementException("Array is empty");
		}
		int min = array[0];
//		swap(0, size - 1);
		array[0] = array[size - 1];
		size --;
		percolateDown(0);
		return min;
	}
	
	public void offer(int num) {
		if(size == array.length) {
			int[] newArray = new int[(int) (array.length * 1.5)];
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size] = num;
		size++;
		percolateUp(size - 1);	//** after size++, num is at array[size - 1]
	}
	
	public void update(int num, int index) {
		if(index < 0 || index > array.length - 1) {
			throw new IllegalArgumentException("index out of bound");
		}
		else {
			int result = array[index];
			array[index] = num;
			// just need to compare num with the original value it replaces
			if(result < num) {
				percolateDown(index);
			}
			else {
				percolateUp(index);
			}
		}
	}
	
	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String args[]) {
		int[] array = {7, 3, 2, 5, 6, 4};
		MinHeap minHeap = new MinHeap(array);
		System.out.println(Arrays.toString(minHeap.array));
		minHeap.update(9, 2);
		System.out.println(Arrays.toString(minHeap.array));
	}
}
