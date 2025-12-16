package leetcode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductExceptSelf {
	public static Logger logger = Logger.getLogger(ReverseWords.class.getName());
	
	public static void main(String args[])	{
		int nums[] = {-1,0,1,2,3};
		int nums1[] = productExceptSelf(nums);
		for (int i : nums1) {
			logger.log(Level.INFO, Integer.toString(i));
		}
	}
	
    public static int[] productExceptSelf(int[] nums) {
    	long total = 1l;
    	int zeroCnt = 0;
    	for (int i : nums)	{
    		if (i == 0)	{
    			++zeroCnt;
    		}	else	{
        		total = total * i;
    		}
    	}
    	int result[] = new int[nums.length];
    	// if input array has 2 or more zeros then all result values are 0
    	if (zeroCnt >= 2)	{
    		result = new int[nums.length];
    		return result;
    	}
    	for (int i = 0; i < nums.length; i++)	{
    		if (nums[i] == 0)	{
    			// scenario of one 0 in input, result will have total without dividing by 0
    			result[i] = (int)total;
    		}	else	{
    			if (zeroCnt == 1)	{
    				//if input has a 0 then result = 0 unless nums[i] = 0
    				result[i] = 0;
    			}	else	{
    				result[i] = (int)(total / nums[i]);
    			}
    		}
    	}
    	return result;
    }

    public static int[] productExceptSelf1(int[] nums) {
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
