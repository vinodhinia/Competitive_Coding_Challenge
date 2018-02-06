import java.util.*;

import org.w3c.dom.Node;

public class Solution {
	
	
	
	public static boolean validWordSquare1(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
	
	public static int isPalindrome(String A) {
        A = A.toLowerCase();
        int start =0, end = A.length()-1;
        while(start <= end){
            if(Character.isLetterOrDigit(A.charAt(start))){
            		if(Character.isLetterOrDigit(A.charAt(end))) {
            			if(A.charAt(start) == (A.charAt(end))){
                            start++;
                            end--;
                     }else {
                    	 return 0;
                     }
            		}else {
            			end--;
            		}
            }else {
            		start++;
            }
        }
        return 1;
    }
	
	public static String longestCommonPrefix(ArrayList<String> A) {
        Collections.sort(A);
        String first = A.get(0);
        String last = A.get(A.size()-1);
        
        if(A.size() == 1)
        	return A.get(0);
        
        int start =0; 
        while(start < first.length()){
            if(first.charAt(start) == last.charAt(start)){
                start++;
            }else{
                return first.substring(0, start);
            }
        }
        return first;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> s = new ArrayList<String>();
//		s.add("aaaaaaaaaaaaaaaaaaaaaaa");
//		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaa");
//		s.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		"aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" 
//		"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//		"aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		"aaaaaaaaaaaaaaaaaaaaaa";
//		"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" 
//		
//		s.add("abcd");
//		s.add("abde");
//		s.add("abcf");
		
		System.out.println(longestCommonPrefix(s));
		
		
		
	}

}
