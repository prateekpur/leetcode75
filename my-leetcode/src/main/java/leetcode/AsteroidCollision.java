package leetcode;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsteroidCollision {
	public static Logger logger = Logger.getLogger(RemoveStars.class.getName());
	public static void main(String args[])	{
		logger.setLevel(Level.INFO);
		//logger.log(Level.INFO, ":" + asteroidCollision(new int[] {5,10,-5}));
		//logger.log(Level.INFO, ":" + asteroidCollision(new int[] {8,-8}));
		//logger.log(Level.INFO, ":" + asteroidCollision(new int[] {10,2,-5}));
		//logger.log(Level.INFO, ":" + asteroidCollision(new int[] {-2,-1,1,2}));
		logger.log(Level.INFO, ":" + asteroidCollision(new int[] {-2,-2,1,-2}));
		//-2,-2,1,-2
	}
	
    static public int[] asteroidCollision(int[] asteroids) {
    	Stack<Integer> stack = new Stack();
    	for (int num : asteroids)	{
    		if (stack.isEmpty())	{
    			stack.push(num);
    			continue;
    		}
    		pushToStack(stack, num);
    		/*int num1 = stack.pop();
    		if ((num > 0 && num1 > 0) || (num < 0 && num1 < 0))	{
    			stack.push(num1);
    			stack.push(num);
    		}	else	{
    			if (num + num1 == 0)	{
    				continue;
    			}
    			if (num + num1 > 0)	{
    				//push positive number
    				if (num > 0)	{
    					stack.push(num);
    				}	else	{
    					stack.push(num1);
    				}
    			}	else	{
    				//push negative number
    				if (num < 0)	{
    					stack.push(num);
    				}	else	{
    					stack.push(num1);
    				}
    			}
    		}*/
    	}
        Object obj[] = (stack.toArray());
        int num2[] = new int[obj.length];
        for (int i = 0; i < obj.length; ++i)	{
        	num2[i] = (int)obj[i];
        }
        return num2;
    }
    
    static public void pushToStack(Stack<Integer> stack, int num)	{
    	if(stack.isEmpty())	{
    		stack.push(num);
    		return ;
    	}
    	while(!stack.isEmpty())	{
    		int num1 = stack.pop();
    		if((num > 0 && num1 > 0) || (num < 0 && num1 < 0) || (num > 0 && num1 < 0))	{
    			stack.push(num1);
    			stack.push(num);
    			return;
    		}
    		if (num + num1 == 0)	{
    			return;
    		}
			if (num + num1 > 0)	{
				//push positive number
				if (num > 0)	{
					pushToStack(stack, num);
					return;
				}	else	{
					stack.push(num1);
					return;
				}
			}	else	{
				//push negative number
				if (num < 0)	{
					pushToStack(stack, num);
					return;
				}	else	{
					stack.push(num1);
					return;
				}
			}
    	}
    }

}
