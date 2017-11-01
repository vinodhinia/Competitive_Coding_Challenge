
import java.util.*;

public class DiffPairs {
	
	static public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               map.put(nums[i], map.get(nums[i]) + 1); 
            }else{
                map.put(nums[i], 1);
            }
                
        }
        
        int count = 0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(k == 0){
                if(m.getValue() == 2)
                    count++;
            }
            else if(map.containsKey(Math.abs(m.getKey()+k))){
                count++;
            }
        }
        return count;
    }
	
	
	static boolean isMatch(String text, String pattern) {
	    // your code goes here
	    if(text == null || pattern == null) return text == pattern;
	    
	    int m = text.length();
	    int n = pattern.length();
	    
	    boolean[][] dp = new boolean[m+1][n+1];
	    
	    dp[0][0] = true;
	    for(int j=1; j<n; j++){
	      if(pattern.charAt(j) == '*') dp[0][j+1] = dp[0][j-1];
	    }
	    for(int i=1; i<=m; i++){
	      for(int j=1; j<=n; j++){
	        if(pattern.charAt(j-1) != '*'){
	          dp[i][j] = (text.charAt(i-1) == pattern.charAt(j-1)|| pattern.charAt(j-1) == '.') && dp[i-1][j-1];
	        }else{
	          dp[i][j] = dp[i][j-2] || dp[i-1][j] && (text.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.');
	        }
	      }
	    }
	    return dp[m][n];
	  }
	
	static public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	for(int j=1;j<nums.length;j++) {
        		if(nums[j-1] == 0) {
        			//swap j-1 and j
        			int temp = nums[j-1];
        			nums[j-1] = nums[j];
        			nums[j] = temp;
        		}
        	}
        }
//        for(int i:nums) {
//        	System.out.print(i + " ");
//        }
    }

	static public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> list = new HashSet<Integer>();
        int[] res;
        for(int i:nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                list.add(nums2[i]);
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            result[index++] = num;
        }
        return result;
    }
	
	
	static public String reverseStr(String s, int k) {
        char[] cArr = s.toCharArray();
        int i=0,j=i+k-1;
        if(s.length() < k)
        	return new StringBuffer(s).reverse().toString();
        while(i<s.length() && j<s.length()){
            int t = i;
            cArr = swap(cArr,i,j);
            i = t + 2*k;
            j=i+k-1;
        }
        int diff = j-i;
        if(i<s.length() && diff < k) {
        	j = s.length()-1;
        	cArr = swap(cArr,i,j);
        }
        return new String(cArr);
    }
	
	static public char[] swap(char[] cArr, int i, int j) {
		while(i < j){
            //swap i and j
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
            i++;
            j--;
        }
		return cArr;
	}
	
	static public boolean isPalindrome(String s) {
		int head = 0,tail = s.length()-1;
		while(head <  tail) {
			char chead = s.charAt(head);
			char ctails = s.charAt(tail);
			if(!Character.isLetterOrDigit(chead))
				head++;
			else if(!Character.isLetterOrDigit(ctails))
				tail++;
			else {
				if(Character.toLowerCase(chead)!=Character.toLowerCase(ctails)) {
					return false;
				}else {
					head++;
					tail--;
				}
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiffPairs d = new DiffPairs();
		int[] a = {1,3,1,5,4};
		int k = 0;
//		System.out.println(findPairs(a,k));
		
//		int[] nums1 = {1,2,2,1};
//		int[] nums2 = {2,2};
//		
//		int[] r = intersection(nums1, nums2);
//		for(int i=0;i<r.length;i++) {
//			System.out.print(r[i] + " ");
//		}
//		System.out.println();
		
		
//		int[] n = {0, 1, 0, 3, 12};
//		moveZeroes(n);
		
		//System.out.println(isMatch("abbb", "ab*"));
//		System.out.println(reverseStr("abcdefgabcdefg",5));
		System.out.println(isPalindrome("aa"));
		
			}

}