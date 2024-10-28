package leetcode;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveStars {
	public static Logger logger = Logger.getLogger(RemoveStars.class.getName());
	public static void main(String args[])	{
		logger.setLevel(Level.INFO);
		logger.log(Level.INFO, removeStars("erase*****"));
	}
	
    public static String removeStars(String s) {
    	Stack<Character> stack = new Stack();
    	for (char ch : s.toCharArray())	{
    		if (ch == '*')	{
    			stack.pop();
    		}	else	{
    			stack.push(ch);
    		}
    	}
    	StringBuilder bld = new StringBuilder("");
    	while(!stack.isEmpty())	{
    		bld.insert(0, stack.pop());
    	}
    	return bld.toString();
    }

}
