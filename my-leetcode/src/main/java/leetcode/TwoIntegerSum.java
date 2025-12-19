package leetcode;

public class TwoIntegerSum {
	public static void main(String args[])	{
		int nums[] = {1,2,3,4};
		twoSum(nums, 3);
	}
	
    public static int[] twoSum(int[] numbers, int target) {
    	int nums[] = new int[2];
    	int start = 0, end = numbers.length - 1;
    	while (start < end)	{
    		if (numbers[start] + numbers[end] == target)	{
    			nums[0] = ++start;
    			nums[1] = ++end;
    			return nums;
    		}	else if (numbers[start] + numbers[end] < target)	{
    			++start;
    		}	else	{
    			--end;
    		}
    	}
    	return nums;
    }
}
