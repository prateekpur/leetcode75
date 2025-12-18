package leetcode;

public class PalindromeCheck {
	public static void main(String args[])	{
		isPalindrome("tab a cat");
	}
	
    public static boolean isPalindrome(String s) {
    	if (s.isEmpty())	{
    		return true;
    	}
    	s = s.replaceAll("[^a-zA-Z0-9]", "");
    	s = s.toLowerCase();
    	//s = s.trim();
    	if (s.isEmpty())	{
    		return true;
    	}
    	int len = s.length();
    	for (int pos = 0; pos <= len / 2; ++pos)	{
			System.out.println(s.charAt(pos) + " : " + s.charAt(len - 1 - pos));
    		if (s.charAt(pos) != s.charAt(len - 1 - pos))	{
    			return false;
    		}
    	}
        return true;
    }

}
