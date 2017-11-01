
public class NeedleInHayStack {
	
	public int strStr(String haystack, String needle) {
		int i=0,j=0;
		int[] lps = computeLPS(needle.toCharArray());
		while(i<haystack.length() && j < needle.length()) {
			if(haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
		}
		if(j == needle.length())
			return (i-(needle.length()));
		return -1;
    }
	
	
	public int[] computeLPS(char[] pattern) {
		int j=0,i=1;
		int[] lps = new int[pattern.length];
		for(i=1;i<pattern.length;) {
			if(pattern[i] == pattern[j]) {
				lps[i] = j+1;
				i++;
				j++;
			}else {
				if(j!=0) {
					j = lps[j-1];
				}else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NeedleInHayStack needle = new NeedleInHayStack();
		String pattern = "abcdabcy";
		String str = "abcxabcdabcdabcy";
		System.out.println(needle.strStr(str, pattern));
	}

}
