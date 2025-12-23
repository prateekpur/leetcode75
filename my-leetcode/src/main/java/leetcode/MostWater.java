package leetcode;

public class MostWater {
	public static void main(String args[])	{
		int nums[] = {2,2,2};//{1,7,2,5,4,7,3,6};
		maxArea(nums);
	}
	
    public static int maxArea(int[] heights) {
    	int start = 0, end = heights.length - 1;
    	int maxArea = 0;
    	while (start != end)	{
    		int area = (end - start) * Math.min(heights[start], heights[end]);
    		maxArea = Math.max(maxArea, area);
    		if (heights[start] > heights[end])	{
    			--end;
    		}	else	{
    			++start;
    		}
    	}
    	return maxArea;
    }

}
