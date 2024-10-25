package leetcode;

public class MergeWords {
    public String mergeAlternately(String word1, String word2) {
		char ch1[] = word1.toCharArray();
		char ch2[] = word2.toCharArray();
		StringBuilder bld = new StringBuilder();
		int posOne = 0, posTwo = 0;
		boolean mergeOne = true;
		while (posOne < word1.length() && posTwo < word2.length())	{
			  if (mergeOne)	{
				  bld.append(ch1[posOne++]);
			  }	else	{
				  bld.append(ch2[posTwo++]);
			  }
			  mergeOne = !mergeOne;
		}
		if (posOne == word1.length())	{
			///merge remaining chars of two
			for (int i = posTwo; i < word2.length(); ++i)	{
				bld.append(ch2[i]);
			}
		}
		if (posTwo == word2.length())	{
			///merge remaining chars of one
			for (int i = posOne; i < word1.length(); ++i)	{
				bld.append(ch1[i]);
			}
		}
		return bld.toString(); 
    }
}
