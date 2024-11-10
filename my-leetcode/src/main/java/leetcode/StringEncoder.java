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
	
	public static void decodeString2(String s)	{
		int tmp = 0, cntOpeningBrackets=0;
		boolean openingBracket = false;
		StringBuilder prefix = new StringBuilder(), withinBracket = new StringBuilder();
		for (int i = 0; i < s.length(); ++i)	{
			if(openingBracket)	{
				withinBracket.append(s.charAt(i));
			}
			if (!openingBracket && intSet.contains(s.charAt(i)))	{
				tmp *= 10;
				tmp += Integer.parseInt(Character.toString(s.charAt(i)));
			}
			if (s.charAt(i) == '[')	{
				++cntOpeningBrackets;
				openingBracket = true;
			}
			else if (s.charAt(i) == ']')	{
				--cntOpeningBrackets;
				if (cntOpeningBrackets == 0)	{
					//remove last character from withinBracket
					withinBracket.deleteCharAt(withinBracket.lastIndexOf("]"));
					logger.log(Level.INFO, "prefix : " + prefix.toString() + " : count : " + Integer.toString(tmp) + " : between brackets : " + withinBracket.toString());
					return;
				}
			}
		}
	}
	
	public static String decodeString1(String s, int index) {
		StringBuilder bld = new StringBuilder("");
		Stack<Character> stack = new Stack();
		Set<Character> intSet = new HashSet();
		int tmp = 0, openingBrackets=0;
		intSet.add('0');intSet.add('1');intSet.add('2');intSet.add('3');intSet.add('4');intSet.add('5');intSet.add('6');intSet.add('7');intSet.add('8');intSet.add('9');
		for (int i = index; i < s.length(); ++i)	{
			char c = s.charAt(i);
			if (tmp != 0)	{
				logger.log(Level.INFO, " : " + tmp);
			}
			if (c == ']')	{
				if (openingBrackets == 0)	{
					return bld.toString();
				}
				--openingBrackets;
				//find string till ']'
			}	else if (c == '[')	{
				++openingBrackets;
				String s1 = decodeString1(s, ++i);
				logger.info("String : " + s1);
				bld.append(s1);
			}	else if (intSet.contains(c)){
				tmp *= 10;
				tmp += Integer.parseInt(Character.toString(c));
			}	else	{
				bld.append(c);
			}
		}
		return "";
	}
	
	public static String expandString(String s, int index)	{
		StringBuilder bld = new StringBuilder("");
		int cntOpen = 1;
		for (int i = index; i < s.length() && cntOpen != 0; ++i)	{
			if (s.charAt(i) == '[')	{
				++cntOpen;
				bld.append(expandString(s, ++index));
			}	else if (s.charAt(i) == ']') {
				--cntOpen;
			}	else	{
				bld.append(s.charAt(i));
			}
		}
		return bld.toString();
	}
	
	public static String decodeString(String s) {
		StringBuilder bld = new StringBuilder("");
		Set<Character> intSet = new HashSet();
		intSet.add('0');intSet.add('1');intSet.add('2');intSet.add('3');intSet.add('4');intSet.add('5');intSet.add('6');intSet.add('7');intSet.add('8');intSet.add('9');
		int tmp = 0;
		boolean startSquare = false;
		for (char c: s.toCharArray())	{
			if(intSet.contains(c))	{
				tmp *= 10;
				tmp += Integer.parseInt(Character.toString(c));
			}	else if (c == '[')	{
				startSquare = true;
			}	else if (c == ']')	{
				logger.log(Level.INFO, bld.toString() + " : " + Integer.toString(tmp));
				bld.setLength(0);
				tmp = 0;
				startSquare = false;
			}	else	{
				bld.append(c);
			}
		}
		logger.log(Level.INFO, bld.toString());
		
		return "";
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
    /*public static String decodeString(String s) {
    	logger.setLevel(Level.INFO);
    	int nidex = 0;
    	while (s.indexOf(']') != -1)	{
    		int i = s.indexOf('[');
    		String s1 = s.substring(i+1, s.indexOf(']'));
    		logger.log(Level.INFO, s1);
    	}
    	int i = s.indexOf(']');
    	return "";
    }*/
    
    public static int getNum(int index)	{
		logger.log(Level.INFO, " : "+index);
    	return -1;
    }

}
