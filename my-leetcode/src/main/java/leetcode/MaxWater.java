package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxWater {
	public static Logger logger = Logger.getLogger(MaxWater.class.getName());
	public static void main(String args[])	{
		maxArea(new int[] {1,1});
	}
	
    public static int maxArea(int[] height) {
		logger.setLevel(Level.INFO);
    	int start = 0, end = height.length-1;
    	int maxvolume = 0;
    	while (start != end)	{
    		int volume = Math.min(height[start],  height[end]) * (end - start);    		
    		maxvolume = Integer.max(maxvolume, volume);
    		logger.log(Level.INFO, "Volume : " + volume + " : " + maxvolume);
    		if (height[start] > height[end])	{
    			end--;
    		}	else	{
    			start++;
    		}
    	}
    	return maxvolume;
    }
}
