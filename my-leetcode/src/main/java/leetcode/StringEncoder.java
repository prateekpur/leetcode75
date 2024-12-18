package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringEncoder {
	public static Logger logger = Logger.getLogger(StringEncoder.class.getName());
	
	public static void main(String args[])	{
		//logger.log(Level.INFO, ":" + decodeString3("3[a]2[bc]"));
		logger.log(Level.INFO, ":" + decodeString3("3[a]2[bc]"));
		logger.log(Level.INFO, ":" + decodeString3("2[abc]3[cd]ef"));
		logger.log(Level.INFO, ":" + decodeString3("3[a2[c]]"));
		//2[abc]3[cd]ef		3[a2[c]]
		;
	}
	
	public static String decodeString3(String s)	{
		Set<Character> intSet = new HashSet();
		intSet.add('0');intSet.add('1');intSet.add('2');intSet.add('3');intSet.add('4');intSet.add('5');intSet.add('6');intSet.add('7');intSet.add('8');intSet.add('9');
		if (!s.contains("["))	{
			return s;
		}
		int tmp = 0, openBracket = 0, lastIndex=0;
		StringBuilder prefix = new StringBuilder(), suffix = new StringBuilder();
		int openIndex = s.indexOf('[');
		//find closing bracket
		for (int i = openIndex; i < s.length(); ++i)	{
			if (s.charAt(i) == '[')	{
				++openBracket;
			}
			if (s.charAt(i) == ']')	{
				--openBracket;
			}
			if (openBracket == 0)	{
				lastIndex = i;
				break;
			}
		}
		if (openIndex == s.length())	{
			//logger.log(Level.INFO, s);
		}
		for (int i = 0; i < openIndex; ++i)	{
			if (intSet.contains(s.charAt(i)))	{
				tmp *= 10;
				tmp += Integer.parseInt(Character.toString(s.charAt(i)));
			}	else	{
				prefix.append(s.charAt(i));
			}
		}
		//int lastIndex = s.lastIndexOf(']');
		String s1 = s.substring(openIndex+1, lastIndex);
		//logger.log(Level.INFO, prefix.toString() + " : " + Integer.toString(tmp) + " : " + s1);
		for (int i = 0; i < tmp; ++i)	{
			prefix.append(s1);
		}
		for (int i = lastIndex+1; i < s.length(); ++i)	{
			prefix.insert(prefix.length(), s.charAt(i));
		}
		//logger.log(Level.INFO, prefix.toString());
		return decodeString3(prefix.toString());
	}

	
	public static String expand(String s, int startIndex)	{
		int cntOpeningBrackets = 1, index = startIndex, secondBracketIndex=-1;
		StringBuilder bld = new StringBuilder("");
		boolean startBracket = false;
		while(index < s.length())	{
			char c = s.charAt(++index);
			if (c == '[')	{
				secondBracketIndex = index + cntOpeningBrackets; 
				++cntOpeningBrackets;
				startBracket = true;
				expand(s, secondBracketIndex);
			}	else if (c == ']')	{
				--cntOpeningBrackets;
			}	else	{
				bld.append(c);
			}
		}
		if (startBracket)	{
			String s2 = expand(s, secondBracketIndex);
		}
		return "";
	}
    
    public static int getNum(int index)	{
		logger.log(Level.INFO, " : "+index);
    	return -1;
    }

}
