//import java.security.KeyStore.Entry;
import java.util.*;
import java.util.Map.Entry;
public class LetterSort {

	public String letterSort(String str) {
		TreeMap<Character, Integer> map = new TreeMap<Character,Integer>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i), 1);
		}
		
		StringBuffer buff = new StringBuffer();
		
		for(Entry<Character, Integer> m : map.entrySet()) {
			int count= m.getValue();
			while(count!=0) {
				buff.append(m.getKey());
				count--;
			}
		}
		return buff.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterSort l = new LetterSort();
		System.out.println(l.letterSort("one"));
	}

}
