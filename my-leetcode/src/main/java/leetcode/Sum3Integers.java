package leetcode;

import java.util.*;

public class Sum3Integers {      
	
	public static void main(String args[])	{
		int nums[] = {-1,0,1,0};//{-1,0,1,2,-1,-4};//{0,1,1};
		threeSum(nums);
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	Set<String> trips = new HashSet();
    	List<List<Integer>> li = new ArrayList();
    	List<int[]> res = new ArrayList();
    	for (int i = 0; i < nums.length; ++ i)	{
    		res = twoSum(nums, 0 - nums[i], i);
    		String s = "";
    		for (int result[] : res)	{
    			if (nums[i] <= nums[result[0]] && nums[i] <= nums[result[1]])	{
    				if (nums[result[0]] <= nums[result[1]])	{
    					s = nums[i] + "," + nums[result[0]] + "," + nums[result[1]];
    				}	else	{
    					s = nums[i] + "," + nums[result[1]] + "," + nums[result[0]];
    				}
    			}	else if (nums[result[0]] <= nums[i] && nums[result[0]] <= nums[result[1]])	{
    				if (nums[i] <= nums[result[1]])	{
    					s = nums[result[0]] + "," + nums[i] + "," + nums[result[1]];
    				}	else	{
    					s = nums[result[0]] + "," + nums[result[1]] + "," + nums[i];
    				}
    			}	else	{
    				if (nums[i] <= nums[result[0]])	{
    					s = nums[result[1]] + "," + nums[i] + "," + nums[result[0]];
    				}	else	{
    					s = nums[result[1]] + "," + nums[result[0]] + "," + nums[i];
    				}
    				//nums[result[1]] is lowest
    			}
    			trips.add(s);
    		}
    		
    	}
		//System.out.println("set");
		for (String s1 : trips)	{
			//System.out.println(s1);
			String nums_str[] = s1.split(",");
			List<Integer> nums1 = new ArrayList();
			for (String s2 : nums_str)	{
				nums1.add(Integer.parseInt(s2));
			}
			li.add(nums1);
		}
    	return li;
    }

    public static List<int[]> twoSum(int numbers[], int target, int exclude) {
    	List<int[]> res = new ArrayList();
    	int nums[] = new int[2];
    	int start = 0, end = numbers.length - 1;
    	while (start < end)	{
    		if (start == exclude)	{
    			++start;
    			continue;
    		}
    		if (end == exclude)	{
    			--end;
    			continue;
    		}
    		if (numbers[start] + numbers[end] == target)	{
    			nums[0] = start;
    			nums[1] = end;
    			res.add(nums);
    			++start;
    			nums = new int[2];
    		}	else if (numbers[start] + numbers[end] < target)	{
    			++start;
    		}	else	{
    			--end;
    		}
    	}
    	return res;
    }

}
