import java.util.*;
public class PalindromicString {
	
	
	public boolean isPalindrome(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		if(str.length()%2 == 0) {
			for(Map.Entry<Character, Integer> m:map.entrySet()) {
				if(m.getValue()%2 != 0) {
					return false;
				}
			}
		}else {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
