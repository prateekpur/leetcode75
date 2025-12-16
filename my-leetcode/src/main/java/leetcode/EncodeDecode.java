package leetcode;
import java.util.*;

public class EncodeDecode {
	public static void main(String args[])	{
		EncodeDecode ele = new EncodeDecode();
		List<String> words = new ArrayList();
		//["1,23","45,6","7,8,9"]

		words.add("1,23");
		words.add("45,6");
		words.add("7,8,9");
		//words.add("say");
		//words.add("#");
		//words.add("yes");
		String encoded = ele.encode(words);
		ele.decode(encoded);
	}
	
	static String encode(List<String> words)	{
		StringBuilder bld = new StringBuilder("");
		for (String word : words)	{
			//bld.append("#");
			bld.append(word.length());

			bld.append("#");
			bld.append(word);
		}
		return bld.toString();
	}
	
	static List<String> decode(String encoded)	{
		List<String> words = new ArrayList();
		int start = 0;
		StringBuilder len = new StringBuilder("");
		for (int i = 0; i < encoded.length(); ++i)	{
			if (encoded.charAt(i) >= '0' && encoded.charAt(i) <= '9') {
				//read length
			    len.append(encoded.charAt(i));
			}	else	{
				//read word using start index and length
				++i;
				words.add(encoded.substring(i  , i  + Integer.parseInt(len.toString())));
				i += Integer.parseInt(len.toString()) - 1;
				len.setLength(0);
			}
		}
		if (len.toString().equalsIgnoreCase("0"))	{
			words.add(new String(""));
		}
		return words;
	}

}
