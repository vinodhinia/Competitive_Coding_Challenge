import java.util.*;

public class AnagramPair {
	
	//Method 1
	public boolean isAnagramPair(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		for(int i=0;i<s1.length();i++) {
			if(s2.indexOf(s1.charAt(i))!=-1) {
				s2 = s2.substring(0,s2.indexOf(s1.charAt(i))) + s2.substring(s2.indexOf(s1.charAt(i))+1,s2.length());
			}else 
				return false;
		}
		if(s2.length() == 0) {
			return true;
		}
		return false;
	}
	
	//Method 2 : By Permutaions
	public boolean checkAnagram(String s1, String s2) {
		Set<String> set = new HashSet<String>();
		
		set = permute(s1, 0, s1.length()-1,set);
		if(set.contains(s2))
			return true;
		return false;
	}
	
	public Set<String> permute(String s, int l, int r, Set<String> set) {
		if(l == r) {
			set.add(s);
		
		}
			
		else {
			for(int i=l;i<=r;i++) {
				s = swap(s,l,i);
				set = permute(s, l+1, r,set);
				s = swap(s,l,i);
			}
		}
		return set;
	}
	
	public String swap(String s, int l, int r) {
		char[] carr = s.toCharArray();
		char temp = carr[l];
		carr[l] =carr[r];
		carr[r] = temp;
		return String.valueOf(carr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramPair a = new AnagramPair();
		System.out.println(a.isAnagramPair("racecar", "aaccrres"));
		
		System.out.println("With Permutions");
		String s = "racecar";
		Set<String> set = new HashSet<String>();
		set = a.permute("racecar", 0,s.length()-1,set);
		System.out.println(a.checkAnagram("racecar", "aaccrres"));
	}

}
