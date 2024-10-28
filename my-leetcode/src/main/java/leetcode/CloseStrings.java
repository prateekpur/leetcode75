package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CloseStrings {
	public static Logger logger = Logger.getLogger(CloseStrings.class.getName());
	public static void main(String args[])	{
		logger.log(Level.INFO, "Result !@#!@#!@ : "+ closeStrings("byiwbiibwhyyyibybmbyjiembbbybiyhjbfdmuiiyebbqhbijibbifybbybwmbbyddyyibdiupybbmiymfimvijwypiufywybhbhbjyyyymyyyifwbwuyiybbbbjyjwmduvibfzbmbfyfjpyywiiyuyjbbyhwywbwibbyybiybbwjbfjebymiffyifyijbfiyibibyfbymfkwfbjjhiqiipjmyembwbjijuiuydimwjyeidubdwmdjdijjidyidwbbuwfybmybwyhyfyydbbujzjjuwybibdhiuyfbyjhdbuybybbuyfdlubiimjibijywyiyypbiybbpwywbmvuwuiyiwfbiwdbjiiibiwdiiibiimyfwwbybmjwbfyibixdmuybbdbfyewbyifuubmybbyibibyjwbbibbbwufdbbydifybmbyibidiuybbiuiidjmyuddzvyybyuibjhbbysefjbjmiidbfidybfbyyiybdbubiyhbfdbbbbibwwbmdiwydjbeymmqbihubpjyiuuhibidjidjyhbuhdiybjbidbjdbmddiubiiufymjbuuiwbbubyeeijefuwbyejiybybypyyhbdpbfwhjjbdwbiyiwybbfbiwymwdbbbbiiibbwmdydiuwddhbywbehbyfbizybmyhyiedyibbbmuyjimbyivfejqywdjbybubibyjdmdwbdbmmbjubuiubbbwhbbyhbymhihmdbhubjybdyuibbifbbbhbibybfbjyyjbffiybuemiiwhdbyjebbjyihiwbbyuifiydiybbibubfbifybbyhiiuhbbbbzidbwubwbhbiyybbbyhybyiihijhubfybyzdijbmfuoijiybyyyiubwbbyyyyjjujiyjbjedjdjwwbbyiduyfybyyudbydwiijbbjwybjmiyyyjbubwbcbjyybbmdmwbbjibbwwymbdbmiybiibbhmybybeibifyjybybejdibbbfmbybwyqjdwyibybwmdjbbjhfiyfuubbbfpwybyhjbbyybequyuywyyybjbyyiybwhhbiyiwbfyuyiwyfbjyhibyiiybiwbbjejibdyibbyyudyewypwyyyedfbpbbwyuyjmueyibijyjmyfujydiiyiwibiwuwimbwdyzeyfbfbzwydbbyiwudwjwbybbbjyybyjbbyfyybbiubbmbbibdimyiyybjffybmebbbfbjbuimyjfdbyjiwyyidybijiimwijyyibijdyjbbmeyubmdiwubiwwjfbwybbwihiiwbfuipmbiyebbwhyjfifbuwvdyybdyymfyifjiewmyiydbudbbubbyyiyimbjmwbjhiwfybyhwbibhwfwijmjbmbbebbyibbjbijdhffbdadwddifwbhjdybibwuymyyjbybdywbuebwwiyeymwymyuybyjbwyhimiyimwbzijwwdbhbyffjuybwhfbiibfiwhubyijbhwyuybbemfhfdbtymiyybjjbbyfmhyiymjiibbbdywfjwbbjbyiijubywdffjwmhdwijybwbmidyuyuyibbibibbhuiuibbzbyiwyeijdiebbdbwfbjiyibyifiiyeybbfdbibzbzbbyyfbbjyqmibbmbbiifdbwbbyjibmbyydibdhbbbyyibibyybdmymubjbybwfbuiyburybwbibhbhdjuiiiyufewjbiyjyyybiubizbyhbhyyiyibibbbhyjfijbyjmyybiiiyjbybjbjdduiwywdbumymibyybbbjwuifbbiwddbdddbjbjbdeijjqijiyjydjbiybybyibwhwyefbbyfbdybbdbbyhbywyymdbiybiihiywyjfbwwbdfhqhyuuhiwybbbibmybuyiyweyiiybbibwbhwfybyywjmybmjyieuufnjenbyzuyfimeyiydibmidmybiyfuiuwybbijbjibfyubbefdjziyejibbibhibyyjjwfyjemyhbhwyyiydiyybydmwmbzyfqwbjibjimfyhiuufbyhbmiyfyyyifebfbbbhbifbyidbdbbbwyybebiuubymiyyiiybfyijdiibbpymdmmibyfwufyyjbbumyduyyfyjiiyydbbyyyyfyyiwubbybiidewewiwbbjbbyiibffbubmwdybmwijyigbybymidwfyydyyjifjuybjybibnifjbyibyweyibbmjirbybuvwwuhimywujiymyebjbbhdumeyuiyy", 
												"dikaziirmizqhrdkzikkiazirzviiiiaraikviiairimrdzihiziiizszizzizkiaimhaazdavmaaajlimrikzvhiiiikiizziikrijaiaimzaakizzmrakiziairzaraazraikraaidmihzjizsarzaizismirzsvaazkzsiiziivaaiikivsiiizmzaizrizzzzizikzmkiivijmiiiirvjiziisadrzizjssdiiijzrakqizizkvsazzzkaddmkivairuazsrqjrazzaijkrmzmdsivzddjziimikimmzsazhazjakzvzvzkriirzijmvavaiijurzafziavkrizizjkijzamadzivazzjaakjvavukkiiksizrvgvivivazkmaiijaivrdaskdmsriaizardaikasairakzvmkdsahdiziiiviiihzaavkzvazrizmsarzmikmjkaizifrrkkzmazdsmivvivaiviiizsacaamkzrsdzzaikmizmrzvzjjakazkzzzmzrzijazizimkrikzkiizzzhiizadirdiazdasviarzkirvsaizrisdazszhzziazizrdaziraasdiariaiizkmshumzzadrjaiiiizzsdjaziajziiszdzzsrrsrzzdsiqaihiridizdmadzekmrkismrbrziikrmmizizhrvmjvjzziahikiaajazsdaaikazzdrvjishakmdzajaajhjjivzzrzjaiikirimzijhjzizzzdzziiizazaazahrrzdaszvaavajzkradhhamviijzmkzjizahvksakrszzhisdiikrrzkkimarzizizhorzisrrizruaaijizaizhjizzraissiziarjirjamajadaiiiviaizizmvaazhzraimimvvaiazzkibzasikajkavaavmizzizzadiijajkiiiakikiksmdjzdzzmziikajjzzkzzziazjiairdaiiivisiazzzhdamhmzshrdiziziaazvzsaikrkizhaizrmzarzrzaadviavivdjiiavmziaazkkirddvihkiaiqziiiaijrzkazvazamzizizzsmikiiikddirjjizmrzzmvmzzijmkiivjiimriaidsazaidriakjajziikazaskahzazihrdiiiflzzddkidkzuzijmhzzidihzizidmiqaairmjdadrramaiiijrmaiaiiarjiiiidzmsazmahmjazijihkaiarkazirzazaiakjdvrivhrzazamaaiivzliiqijizzzjzaimzmmhiajimzkikjzikmakviizmijihzdiizizizzrivadaviaiiiiidvziaizzrisrfkirvizjzaidzjjrapkakzrzvvmaimzdidadrjumzaazjuhhziizkddzzrkiiimajmrsazazizdakmiasvkzmazrflkzzaiizhivdzdmvdairzimrrvrzisklzvrkjrkjdzdhzaziiidmiznixjaksiizviiiazzaizkzvizzkhdisvizjasziarzjlikizaidiramzjiamvdaraadrimiaikzaddzzdvaiirdariizriaaizziaizirmizdzizizzzivkakvikiizhiszvkdikiizimkmaiiiirmiiaaywszaiiziiviuzimiaajzzzmakvazvrmsaizaskramsrirzizirrimksvrsjzakavviziirjdfzvidaarmiizriikriarizzrajdzkzdziaiiviaidrsziakikkmiairaaziiiijjiaaiqazihiizziziidzqiiikzkamimiazvzadadzhdzzakvazzzrrkiimsazriiiijariiivzhdzhkarrsimaarzaizijlzdzazvkzazizmmkzqrzmaziziadvziidziiziizvzirizivijaiiaadszduivvkajrazdlimzjisijiqjiaisiabzmzitziraakvakkidmmqikvaiikjjikikjizzaaazizaijsqzvimjzvurmmkzriisdaivkzfmvdzzkazzdkjzkjiviirzrvmajziijmzizmuahikiijrivmaraivdadmirzravazaiimmiiqadzsvrirkzdjavksdlaiivirzlazaiadrjmiirvizizkzzkszizikaghvzmiiqzdmiqhvazmzhikairazkkiivmkjzraiiijaiukrzivjzazidkriziszizkzvarzmmaaiivhmuzmikzadz"));
		//logger.log(Level.INFO, ""+ closeStrings("abbzccca", "babzzczc"));
		//logger.log(Level.INFO, ""+ closeStrings("abc", "bca"));
		//logger.log(Level.INFO, ""+ closeStrings("cabbba", "abbccc"));
		//logger.log(Level.INFO, ""+ closeStrings("a", "aa"));
	}
	
    public static boolean closeStrings(String word1, String word2) {
    	if (word1.length() != word2.length())	{
    		return false;
    	}
    	//anagrams scenario
    	if (isAnagram(word1, word2))	{
    		return true;
    	}
    	//build map again
    	Map<Character, Integer> mapWord1 = new HashMap();
    	for (char ch : word1.toCharArray())	{
    		int cnt = mapWord1.getOrDefault(ch, 0);
    		mapWord1.put(ch, ++cnt);
    	}
    	Map<Character, Integer> mapWord2 = new HashMap();
    	for (char ch : word2.toCharArray())	{
    		int cnt = mapWord2.getOrDefault(ch, 0);
    		mapWord2.put(ch, ++cnt);
    	}
    	//find diffs of both maps
    	List<Character> li = new ArrayList();
    	for (Entry<Character, Integer> en : mapWord1.entrySet())	{
    		if(!mapWord2.containsKey(en.getKey()))	{
    			return false;
    		}
    		if(mapWord2.get(en.getKey()) != en.getValue())	{
    			//logger.log(Level.INFO, " word1 : " + en + " : word2 : " + mapWord2.get(en.getKey()));
    			li.add(en.getKey());
    		}
    	}
    	//remove character with matching count from mapWord1 and mapWord2
    	int maxValWord1 = 0, maxValWord2 = 0;
    	Set<Integer> word1Values = new HashSet(), word2Values = new HashSet();
    	List<Character> common = new ArrayList();
    	for (Character c : mapWord1.keySet())	{
    		if(mapWord2.get(c) == mapWord1.get(c))	{
    			common.add(c);
    		}	else	{
        		word1Values.add(mapWord1.get(c));
        		word2Values.add(mapWord2.get(c));
    		}
    	}
    	for (Character c : common)	{
        	mapWord1.remove(c);
        	mapWord2.remove(c);
    	}
    	
    	//if maxValue of word1map != maxvalue of word2map then false
    	
    	
    	Collections.sort(li);
		//logger.log(Level.INFO, " list : " + li);
		//try swaps 
		boolean matchFound = false;
		int numSwaps = 0;
		do	{
			//find word2 character that can be swapped with first
			matchFound = false;
			char first = li.get(0);
			//find first non-matching character a=537
			
			char second = ' ';
			for (Entry<Character, Integer> en : mapWord2.entrySet())	{
				if (li.contains(en.getKey()) && (en.getValue().intValue() == mapWord1.get(first).intValue()))	{
					second = en.getKey();
					matchFound = true;
					break;
				}
			}
			int mapLength = mapWord1.size();
			if(!matchFound)	{
				logger.log(Level.INFO, "Word maps : " + mapWord1 + " : " + mapWord2);
			}
			if (matchFound)	{
				int value1 = mapWord1.get(first);
				int value2 = mapWord1.get(second);
				mapWord1.replace(first, value1, value2);
				mapWord1.replace(second, value2, value1);
				if (mapWord1.get(first).intValue() == mapWord2.get(first).intValue())	{
					li.remove(li.indexOf(first));
					mapWord1.remove(first);
					mapWord2.remove(first);
				}
				if (mapWord1.get(second).intValue() == mapWord2.get(second).intValue())	{
					li.remove(li.indexOf(second));
					mapWord1.remove(second);
					mapWord2.remove(second);
				}
				++numSwaps;
			}	else	{
				return false;
			}
		}	while(matchFound &&  (li.size() !=0));
    	//compare if mapWord1 and mapWord2 are same
		for (Entry<Character, Integer> en : mapWord1.entrySet())	{
			if (en.getValue() != mapWord2.get(en.getKey()))	{
				return false;
			}
		}
		return true;
    }
    
    static boolean isAnagram(String word1, String word2)	{
    	System.out.println(word1.length() + " : " + word2.length());
    	Map<Character, Integer> mapWord1 = new HashMap();
    	for (char ch : word1.toCharArray())	{
    		int cnt = mapWord1.getOrDefault(ch, 0);
    		mapWord1.put(ch, ++cnt);
    	}
    	//check if second word matches first words map
    	for (char ch : word2.toCharArray())	{
    		if (!mapWord1.containsKey(ch))	{
    			return false;
    		}
    		int cnt = mapWord1.get(ch);
    		if (--cnt != 0)	{
        		mapWord1.put(ch, cnt);
    		}	else	{
    			mapWord1.remove(ch);
    		}
    	}
    	if(!mapWord1.isEmpty()) {
    		return false;
    	}
    	return true;
    }

}
