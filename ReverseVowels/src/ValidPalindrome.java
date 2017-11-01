import java.util.*;
public class ValidPalindrome {

	public boolean isValidPalindrome(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(s.charAt(i), map.get(ch)+ 1);
			}else {
				map.put(ch, 1);
			}
		}
		
		int even=0,odd=0;int i=0;
		for(Map.Entry<Character, Integer> m:  map.entrySet()) {
			if(m.getValue()%2 ==0) {
				even++;
			}else {
				odd++;
			}
		}
		if(even>=1 ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isValidPalindrome("abc"));
	}

}
