import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MissingNumber {

	public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0;i<nums.length;i++) {
        	res ^=i;
        	res ^=nums[i];
        }
        return res;
    }
	
	public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res ^=nums[i];
            
        }
        return res;
    }
	
	public int climbStairs(int n) {
        int distinct_ways = n;
        int count = 0;
        if(n>1){
            distinct_ways = n;
            int t = 0;
            
            while(t+2 <=n){
                count++;
                t = t + 2;
            }
            if(t < n)
                count++;
        }
        return count+distinct_ways;
    }
	
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int[] alphabet= new int[26];
		for(int i=0;i<s.length();i++) {
			alphabet[s.charAt(i) - 'a']++;
			alphabet[t.charAt(i) - 'a']--;
			
		}
		for(int i=0;i<alphabet.length;i++) {
			if(alphabet[i]!=0)
				return false;
		}
		return true;
		
    }
	
	public int findMissingNumber(int[] nums) {
		int result = nums.length+1;
		for(int i=0;i<nums.length;i++) {
			result ^=i+1;
			result ^=nums[i];
		}
		return result;
	}
	
	
	
	public int firstUniqChar(String s) {
		if(s == null ||s.length() == 0)
			return -1;
		int len = s.length();
		int slow =0,fast=1;
		char[] carr = s.toCharArray();
		int[] count = new int[256];
		count[carr[slow]]++;
		while(fast < len) {
			while(slow < len && count[carr[slow]] >  1) slow++;
			if(slow >= len) {
				return -1;
			}
			if(count[carr[slow]] == 0) {
				count[carr[slow]]++;
				fast = slow;
			}
			fast++;
		}
		return slow;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber m = new MissingNumber();
		int[] a = {0,1,2,3,5};
		System.out.println(m.missingNumber(a));
		int[] a1 = {1,1,2,2,3,4,4};
		System.out.println(m.missingNumber(a1));
		System.out.println(m.climbStairs(2));
		System.out.println(m.isAnagram("anagram", "nagaram"));
		System.out.println("First Unique Character ");
		System.out.println(m.firstUniqChar("loveleetcode"));
		int[] nums = {1,4,2};
		
		System.out.println("Missing Number");
		System.out.println(m.findMissingNumber(nums));
	}

}
