import java.security.KeyStore.Entry;
import java.util.*;
public class WordCount {

	public Hashtable<String, Integer> wordCount(String s){
		s = s.toLowerCase();
		s = s.replaceAll("[^\\w\\s]","");
		Hashtable<String, Integer> htable = new Hashtable<String, Integer>();
		String[] sarr = s.split(" ");
		for(int i=0;i<sarr.length;i++) {
			if(htable.containsKey(sarr[i]))
				htable.put(sarr[i], htable.get(sarr[i])+1);
			else
				htable.put(sarr[i], 1);
		}
		return htable;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCount w = new WordCount();
		String s = "It's a man, it's a plane, it's superman! ";
		
		Hashtable<String,Integer> ht = w.wordCount(s);
		
		Enumeration n = ht.keys();
		while(n.hasMoreElements()) {
			String key = (String)n.nextElement();
			System.out.println(key + " " + ht.get(key));
		}
	}

}
