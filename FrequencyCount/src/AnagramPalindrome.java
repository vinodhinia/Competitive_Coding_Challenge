
public class AnagramPalindrome {
	
	public boolean isAnagramPalindrome(String s) {
		int[] characters = new int[256];
		for(int i=0;i<s.length();i++) {
			characters[s.charAt(i)- 'a']++; 
		}
		int countOdd = 0;
		for(int i=0;i<characters.length;i++) {
			if(characters[i]%2!=0) {
				countOdd++;
			}
			if(countOdd > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramPalindrome a = new AnagramPalindrome();
		System.out.println(a.isAnagramPalindrome("cat"));
	}

}
