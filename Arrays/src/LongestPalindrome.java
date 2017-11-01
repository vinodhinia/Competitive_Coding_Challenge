
public class LongestPalindrome {

	public boolean isPalindrome(String s) {
		int start = 0,end = s.length()-1;
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public String longestPalindrome(String s) {
		int max = Integer.MIN_VALUE;
		String res = "";
		for(int startIndex = s.length();startIndex>=0;startIndex--) {
			for(int i=0;i<s.length();i++) {
				if(i+ startIndex <=s.length()) {
					String t = s.substring(i, i+ startIndex);
					if(isPalindrome(t)) {
						if(t.length() > max) {
							max = t.length();
							res = t;
							return res;
						}
					}
				}
			}
		}
		return res;
	}
	
	
	public String longestPalindrome1(String s) {
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	/**
	 * @param args
	 */
	
	public int countBinarySubstrings(String s) {
        int count = 0;
        for(int startIndex = 2;startIndex<=s.length()-1;startIndex++) {
        	for(int i=0;i<s.length();i++) {
        		if(i+startIndex <=s.length()) {
        			String t = s.substring(i, i+startIndex);
        			if(isOneZeroEqual(t)) {
        				System.out.println(t);
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
	
	public boolean isOneZeroEqual(String s) {
		int continiousCountOne = 0,continiousZero = 0,countOne=0,countZero=0;
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i) == '0') {
				if(s.charAt(i+1) =='0') {
					continiousZero++;
					countZero +=2;
				}
			}else if(s.charAt(i) == '1'){
				if(s.charAt(i+1) =='1') {
					continiousCountOne++;
					countOne+=2;
				}
				
			}
			
		}
		
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i) == '0')
				countZero++;
			else 
				countOne++;
		}
		return ((countOne == countZero) || continiousZero == continiousCountOne);
	}
	
	
	 static int longestPalSubstr(String str) {
	        int n = str.length();   // get length of input string
	 
	        // table[i][j] will be false if substring str[i..j]
	        // is not palindrome.
	        // Else table[i][j] will be true
	        boolean table[][] = new boolean[n][n];
	 
	        // All substrings of length 1 are palindromes
	        int maxLength = 1;
	        for (int i = 0; i < n; ++i)
	            table[i][i] = true;
	 
	        // check for sub-string of length 2.
	        int start = 0;
	        for (int i = 0; i < n - 1; ++i) {
	            if (str.charAt(i) == str.charAt(i + 1)) {
	                table[i][i + 1] = true;
	                start = i;
	                maxLength = 2;
	            }
	        }
	         
	        // Check for lengths greater than 2. k is length
	        // of substring
	        for (int k = 3; k <= n; ++k) {
	             
	                  // Fix the starting index
	            for (int i = 0; i < n - k + 1; ++i) 
	            {
	                // Get the ending index of substring from
	                // starting index i and length k
	                int j = i + k - 1;
	 
	                // checking for sub-string from ith index to
	                // jth index iff str.charAt(i+1) to 
	                // str.charAt(j-1) is a palindrome
	                if (table[i + 1][j - 1] && str.charAt(i) == 
	                                          str.charAt(j)) {
	                    table[i][j] = true;
	 
	                    if (k > maxLength) {
	                        start = i;
	                        maxLength = k;
	                    }
	                }
	            }
	        }
	        System.out.print("Longest palindrome substring is; ");
	        printSubStr(str, start, start + maxLength - 1);
	         
	        return maxLength; // return length of LPS
	    }
	 static void printSubStr(String str, int low, int high) {
	        System.out.println(str.substring(low, high + 1));
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		LongestPalindrome p = new LongestPalindrome();
		System.out.println(p.longestPalindrome(s));
		
		System.out.println("Method 2");
		System.out.println(p.longestPalindrome1(s));
		
		System.out.println("Method 3");
		System.out.println(p.longestPalSubstr(s));
		
		System.out.println("Count Binary Substrings");
		System.out.println(p.countBinarySubstrings("10101"));
		
	}

}
