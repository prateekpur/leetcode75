package leetcode;
import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

	public static void main(String args[])	{
		int nums[] = {0,3,2,5,4,6,1,1};
		longestConsecutive(nums);
	}
	
    public static int longestConsecutive(int[] nums) {
    	Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    	Set<Integer> visitedNums = new HashSet();
    	int len = 0;
    	for (int i : numbers)	{
    		if (visitedNums.contains(i))	{
    			continue;
    		}
    		visitedNums.add(i);
    		//find sequence starting at i
    		int nextNumber = i + 1;
    		while (numbers.contains(nextNumber))	{
    			visitedNums.add(nextNumber);
    			nextNumber++;
    		}
    		len = Integer.max(len, nextNumber - i);
    	}
    	return len;
        
    }

}
