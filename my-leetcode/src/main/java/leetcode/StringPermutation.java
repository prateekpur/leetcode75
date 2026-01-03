package leetcode;

public class StringPermutation {
	static final int aVal = 97;
	public static void main(String args[])	{
		System.out.print((int)'a' + ":" + (int)'z');
		String s1 = "hello", s2 = "ooolleoooleh";
		checkInclusion(s1, s2);
	}
	
    public static boolean checkInclusion(String s1, String s2) {
    	int s1Freq[] = new int[26];
    	buildCharCount(s1, s1Freq);
    	for (int i = 0; i < s2.length(); ++i)	{
    		if (s1Freq[s2.charAt(i) - aVal] != 0)	{
    			boolean res = checkString(s2, i, s1Freq, s1.length());
    			if ( res)	return true;
    			s1Freq = new int[26];
    			buildCharCount(s1, s1Freq);
    		}
    	}
    	return false;
    }
    
    static void buildCharCount(String s, int freq[])	{
    	//freq = new int[26];
    	int len = s.length();
    	for (int i = 0; i < len; i++)	{
    		int pos = s.charAt(i) - aVal;
    		freq[s.charAt(i) - 97]++;
    	}
    }
    
    /**
     * @param s - original string s2
     * @param pos - starting position at s2 to be matched
     * @param s1Freq - frequency array for s1
     * @return
     */
    static boolean checkString(String s, int pos, int s1Freq[], int s1Len)	{
    	for (int i = pos; (i < pos + s1Len) && (i < s.length()); ++i)	{
    		if (s1Freq[s.charAt(i) - aVal] == 0)	{
    			return false;
    		}
    		--s1Freq[s.charAt(i) - aVal];
    	}
    	//check if frequency array is 0
    	return true;
    }
}
