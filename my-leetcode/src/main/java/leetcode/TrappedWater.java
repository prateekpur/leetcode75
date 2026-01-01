package leetcode;

public class TrappedWater {
	public static void main(String args[])	{
		int height[] = {0,2,0,3,1,0,1,3,2,1};
		System.out.println(trap(height));
	}
	
    public static int trap(int[] height) {
    	
    	int[] right = new int[height.length], left = new int[height.length];
    	int maxRight = -1, maxLeft = -1;
    	for (int i = 0; i < height.length; ++i)	{
    		right[i] = maxRight;
    		left[height.length -1 - i] = maxLeft;
    		maxRight = Integer.max(maxRight, height[i]);
    		maxLeft = Integer.max(maxLeft, height[height.length - 1 - i]);
    	}
    	int maxWater = 0;
    	for (int i = 0; i < height.length; ++i)	{
    		int water = Math.min(left[i], right[i]) - height[i];
    		if (water > 0)	{
    			maxWater += water;
    		}
    	}
    	return maxWater;
    }
}
