package leetcode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseWords {
	public static Logger logger = Logger.getLogger(ReverseWords.class.getName());
	public static void main(String args[])	{
		logger.log(Level.INFO, reverseWords("a good   example"));
	}
	
    public static String reverseWords(String s) {
    	logger.setLevel(Level.INFO);
    	s = s.strip();
    	String words[] = s.split(" ");
    	/*for (String s1 : words) {
    		logger.log(Level.INFO, s1);
    	}*/
    	StringBuilder bld = new StringBuilder("");
    	for (int i = words.length-1; i>= 0 ;i--)	{
    		logger.log(Level.INFO, words[i]);
    		if(!words[i].isBlank())	{
    			bld.append(words[i]);
    		}
    		if (i != 0 && !words[i].isBlank())	{
    			//logger.log(Level.INFO, "if loop : "+bld.toString());
    			bld.append(" ");
    	    	//logger.log(Level.INFO, "if loop : "+bld.toString());
    		}
    	}
/*    	for (String s1 : words)	{
    		if (!s1.isBlank())	{
        		bld.insert(0, s1 + " ");
    		}
    		//logger.log(Level.INFO, bld.toString());
    	}*/
    	//logger.log(Level.INFO, bld.toString());
    	return bld.toString();
    }

}
