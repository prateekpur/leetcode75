package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringGCD {
    public static String gcdOfStrings(String str1, String str2) {
    	List<String> answers = new ArrayList();
    	StringBuilder bld = new StringBuilder("");
    	for (char ch : str1.toCharArray())	{
    		bld.append(ch);
    		//check if this divides both strings
    		if (str1.replaceAll(bld.toString(), "").isEmpty() && str2.replaceAll(bld.toString(), "").isEmpty())	{
    			answers.add(bld.toString());
    		}
    	}
    	if (answers.isEmpty())	{
        	return "";
    	}
    	String max = answers.get(0);
    	for (String s1 : answers)	{
    		if (s1.length() > max.length())	{
    			max = s1;
    		}
    	}
    	return max;
    }

}
