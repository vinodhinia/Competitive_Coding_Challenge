import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TwoSum {
	
	public int twoSum(int[] nums) {
		int min_l=0,min_r=1;
		int min_sum = nums[0] + nums[1];
		int sum = 0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				sum = nums[i] + nums[j];
				if(Math.abs(sum) < Math.abs(min_sum)) {
					min_sum = sum;
					min_l = i;
					min_r = j;
				}
			}
		}
		return min_sum;
	}
	
	
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++) {
        	int location  =  Math.abs(nums[i]) - 1;
        	if(nums[location] < 0) {
        		result.add(Math.abs(nums[location]));
        	}else {
        		nums[location] = -nums[location];
        	}
        }
        return result;
        
    }
	
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length ==0)
			return 0;
        int max = Integer.MIN_VALUE;
        int count =1;
        for(int i=0;i<nums.length-1;i++) {
        	if(nums[i] < nums[i+1]) {
        		count++;
        	}else {
        		max = Math.max(count, max);
        		count = 1;
        	}
        }
        return Math.max(count, max);
    }
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        while(n!=0) {
        	int i=0;
        	for(i=0;i<flowerbed.length;i++) {
        		if(flowerbed[i]==1 && i+3 <flowerbed.length) {
        			if(flowerbed[i+1]==0 && flowerbed[i+2] == 0 && flowerbed[i+3]==0) {
        				flowerbed[i+2] =1;
        				n--;
        			}
        				
        		}
        	}
        	if(i>=flowerbed.length && n!=0)
    			return false;
        }
        return true;
    }
	
	
	//[],1,101,11,1111
	public int findMaxConsecutiveOnes(int[] nums) {
		int count  = 0;int max= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	if(nums[i] == 1) {
        		count++;
        	}else if(nums[i] == 0) {
        		max = Math.max(count, max);
        		count = 0;
        	}
        }
        return Math.max(count, max);
    }

	public String addBinary(String a, String b) {
        int lena =  a.length();
        int lenb = b.length();
        
        //padding
        if(lenb < lena) {
        	int diff = lena -lenb;
        	while(diff!=0) {
        		b = '0' + b;
        		diff--;
        	}
        }else if(lena < lenb) {
        	int diff = lenb - lena;
        	while(diff!=0) {
        		a = '0' + a;
        		diff--;
        	}
        }
        
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        int carry = 0;
        StringBuffer buff = new StringBuffer();
        
        
        for(int i=cha.length-1;i>=0;i--) {
        	if(cha[i]=='1' && chb[i] == '1') {
        		if(carry == 1) {
        			buff.append("1");
        			carry = 1;
        		}else {
        			buff.append("0");
        			carry = 1;
        		}
        	}else if(cha[i]=='0' && chb[i]=='1' || cha[i]=='1' && chb[i] == '0') {
        		if(carry == 1) {
        			buff.append("0");
        			carry = 1;
        		}else {
        			buff.append("1");
        			carry = 0;
        		}
        	}else if(cha[i] == '0' && chb[i] == '0') {
        		if(carry == 0) {
        			buff.append("0");
            		carry = 0;
        		}else {
        			buff.append("1");
            		carry = 0;
        		}
        	}
        		
        	
        }
        
        if(carry == 1) {
        	buff.append("1");
        }
        return new String(buff.reverse());
    }
	
	public int romanToInt(String s) {
		s = s.toUpperCase();
        HashMap<Character,Integer> roman = new HashMap<Character,Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int sum = 0;
        
        char[] ch = s.toCharArray();
        if(ch.length == 1)
        	return roman.get(ch[0]);
        if(ch.length >=2) {
        	if(roman.get(ch[0]) >= roman.get(ch[1])) {
        		sum += roman.get(ch[0]) + roman.get(ch[1]);
        	}else if(roman.get(ch[0]) < roman.get(ch[1])) {
        		sum += roman.get(ch[1]) - roman.get(ch[0]);
        	}
        }
        for(int i=1;i<ch.length-1;i++) {
        	if(roman.get(ch[i]) >= roman.get(ch[i+1])) {
        		sum +=  roman.get(ch[i+1]);
        	}else if(roman.get(ch[i]) < roman.get(ch[i+1])) {
        		sum += roman.get(ch[i+1]) - 2*roman.get(ch[i]);
        	}
        }
        return sum;
    }
	
	public boolean repeatedSubstringPattern(String s) {
        if(s.length()%2 == 0) {
        	int mid =  s.length()/2;
        	if(s.substring(0, mid).equals(s.substring(mid,s.length()))) {
        		return true;
        	}
        }
        return false;
    }
	
	public int[] twoSum(int[] numbers, int target) {
        int left=0,right = numbers.length-1;
        int[] result = new int[2];
        while(left < right) {
        	if(numbers[left] + numbers[right] == target ) {
        		result[0] = left+1;
        		result[1] = right + 1;
        		return result;
        	}else if(numbers[left] + numbers[right] > target ) {
        		right--;
        	}else {
        		left++;
        	}
        }
        return result;
    }
	
	public int rob(int[] nums) {
		int sum_odd = 0;
		int sum_even = 0;
        for(int i=0;i<nums.length;i++) {
        	if(i%2 == 0) {
        		sum_even += nums[i];
        	}else {
        		sum_odd += nums[i];
        	}
        }
        return Math.max(sum_odd, sum_even);
    }
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
        int lenP= p.length();
        for(int i=0;i<s.length()-p.length()+1;i++) {
        	String t = s.substring(i, i+p.length());
        	if(checkAnagram(t,p)) {
        		list.add(i);
        	}
        	
        }
        return list;
    }
	
	public boolean checkAnagram(String t,String p) {
        int[] stringT = new int[256];
        int[] stringP =  new int[256];
        
		for(int i= 0;i<p.length();i++){
            stringP[(int)p.charAt(i)]++;
            stringT[(int)t.charAt(i)]++;
        }
        
        if(Arrays.equals(stringT, stringP))
			return true;
		return false;
	}
	
	public boolean isIsomorphic1(String s, String t) {
		 int[] m1 = new int[256], m2 = new int[256];
		 int n = s.length();
	        for (int i = 0; i < n; ++i) {
	            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
	            System.out.println(s.charAt(i));
	            System.out.println(t.charAt(i));
	            m1[s.charAt(i)] = i + 1;
	            m2[t.charAt(i)] = i + 1;
	        }
	        return true;
    }
	
	
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++) {
        	if(map.containsKey(s.charAt(i))) {
        		if(map.get(s.charAt(i)) == t.charAt(i))
        			continue;
        		else
        			return false;
        	}else {
        		if(!map.containsKey(t.charAt(i)))
        			map.put(s.charAt(i), t.charAt(i));
        		else
        			return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum s = new TwoSum();
		int[] nums = {1,60,-10,-70,-80,85};
		System.out.println(s.twoSum(nums));
		int[] flowerbed = {1,0,0,0,1};
		//System.out.println(s.canPlaceFlowers(flowerbed, 1));
		int[] a = {1,3,5,7};
		System.out.println(s.findLengthOfLCIS(a));
		
		System.out.println("Find Duplicates \n");
		int[] a1 = {4,2,3,7,5,2,3,1};
		List<Integer> list = s.findDuplicates(a1);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Maximum Consicutive Ones");
		int[] n = {};
		System.out.println(s.findMaxConsecutiveOnes(n));
		
		System.out.println(s.addBinary("1010", "1011"));
		System.out.println(s.romanToInt("MCMXCVI"));
		System.out.println(s.repeatedSubstringPattern("abcabcabcabcabcabcabcabc"));
		
		int[] n1 = {2, 7, 11, 15};
		int target = 9;
		int[] r = s.twoSum(n1, target);
		//System.out.println());
		System.out.println("Checking anagram");
		System.out.println(s.checkAnagram("abc", "bca"));
		System.out.println(s.findAnagrams("cbaebabacd", "abc"));
		
		System.out.println("IsoMorphic string");
		System.out.println(s.isIsomorphic("ab", "aa"));
	}
	

}
