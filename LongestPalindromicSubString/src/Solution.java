
public class Solution {
	
	public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i=0;i<s.length();i++) {
        		dp[i][i] = true;
        }
        int maxLen = 1;
        
        int start = 0;
        for(int i=0;i<s.length()-1;i++) {
        		if(s.charAt(i) == s.charAt(i+1)) {
        			dp[i][i+1] = true;
        			start = i;
        			maxLen = 2;
        		}
        }
        
        for(int k=3;k<=s.length();k++) {
	        	for (int i = 0; i < s.length() - k + 1; ++i) {
	        		int j = i + k - 1;
	        		if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
	        			if (k > maxLen) {
	                        start = i;
	                        maxLen = k;
	                    }
	        		}
	        	}
        }
        return s.substring(start, start+maxLen-1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = "forgeeksskeegfor";
        System.out.println("Length is: " + 
                                 s.longestPalindrome(str));
	}

}
