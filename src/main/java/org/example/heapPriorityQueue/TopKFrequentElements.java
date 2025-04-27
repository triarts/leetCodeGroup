package org.example.heapPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		// Step 1: Count frequencies
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		// Step 2: Use a min-heap (PriorityQueue) to keep top k frequent elements
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
			Comparator.comparingInt(Map.Entry::getValue)
			//opsi lain implementasi //(a, b) -> a.getValue() - b.getValue()
		);

		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll(); // Remove the least frequent element
			}
		}

		// Step 3: Extract the keys from the heap
		int[] result = new int[k];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : minHeap) {
			result[index++] = entry.getKey();
		}

		return result;
	}

	// Test it
	public static void main(String[] args)
	{
		TopKFrequentElements solution = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] result = solution.topKFrequent(nums, k);
		System.out.println(Arrays.toString(result)); // Output should be [1,2]
	}
}