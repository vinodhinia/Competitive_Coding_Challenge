import java.util.*;
import java.util.Map.Entry;
public class CharacterMode {

	public String characterMode(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		s = s.toLowerCase().replaceAll("\\s", "");
		int max = Integer.MIN_VALUE;
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else
				map.put(s.charAt(i), 1);
		}
		
		for(Entry<Character, Integer> m:map.entrySet()) {
			if(m.getValue() > 1 && m.getValue() >= max) {
				max = m.getValue();
				res += m.getKey();
			}
			
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterMode c = new CharacterMode();
		System.out.println(c.characterMode("noon"));
	}

}
