package leetcode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductExceptSelf {
	public static Logger logger = Logger.getLogger(ReverseWords.class.getName());
	
	public static void main(String args[])	{
		int nums[] = {-1,1,0,-3,3};
		int nums1[] = productExceptSelf(nums);
		for (int i : nums1) {
			logger.log(Level.INFO, Integer.toString(i));
		}
	}
	
    public static int[] productExceptSelf(int[] nums) {
    	int result[] = new int[nums.length];
    	int product = 1;
    	for (int i : nums)	{
    		product *= i;
    	}
    	for (int i = 0; i < nums.length; i++)	{
    		if (nums[i] == 0)	{
    			result[i] = 1;
    			for (int j = 0; j < nums.length; j++)	{
    				if (j != i)	{
    					result[i] *= nums[j]; 
    				}
    			}
    			
    		}	else	{
        		result[i] = product / nums[i];
    		}
    	}
    	return result;
    }
}
