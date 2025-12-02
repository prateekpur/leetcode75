package leetcode;
import java.util.*;
import java.util.Map.Entry;

public class TopKElements {
	
	public static void main(String args[])	{
		TopKElements ele = new TopKElements();
		int nums[] = {7,7};
		ele.topKFrequent(nums, 1);
	}
	
    public int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i : nums)	{
    		map.put(i, map.getOrDefault(i, 0) + 1);
    	}
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        minHeap.addAll(map.entrySet());
        int count[] = new int[k];
        for (int i = 0; i < k; ++i)	{
        	count[i] = minHeap.poll().getKey();
        }
    	return count;
    }


}
