package leetcode;
import java.util.*;

public class SlidingWindowMax {
	public static void main(String args[])	{
		int nums[] = {1,2,1,0,4,2,6};
		maxSlidingWindow(nums, 3);
	}
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < k; ++i)	{
        	queue.add(nums[i]);
        }
        int start = 0, end = k;
        while (end < nums.length)	{
        	res[start] = queue.peek();
        	queue.add(nums[end]);
        	queue.remove(nums[start]);
        	++start;
        	++end;
        }
        res[res.length - 1] = queue.peek();
        return res;
    }

}
