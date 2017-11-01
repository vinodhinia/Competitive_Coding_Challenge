import java.util.*;

public class NonDecreasingArray {
HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
	public boolean checkPossibility(int[] nums) {
        int i=-1,j=nums.length;
        while(i<j) {
        	if(nums[++i] > nums[--j])
                return isNonDecreasing(nums,i, j-1) || isNonDecreasing(nums,i+1,j);
        }
        
        return false;
    }
    
    public boolean isNonDecreasing(int[] nums,int start, int end){
    	if(end-start == 1) {
    		if(nums[end] < nums [start])
    			return false;
    	}
        while(start < end-1){
            if(nums[start+1] < nums[start]){
                return false;
            }
            start++;
        }
        return true;
    }
    
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length == 0)
            return 0.0;
        double max = Double.MIN_VALUE;
        double avg = 0.0;int sum=0;
        if(nums.length == 1) {
        	avg = nums[0]/(double)k;
        	return avg;
        }
        for(int i=0;i<nums.length-(k-1);i++){
        	int start = i;
        	int end = i+k-1;
        	while(start <= end) {
        		sum += nums[start];
        		start++;
        	}
        	//sum = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            avg = (sum/(double)k);
            max = Math.max(avg, max);
            sum = 0;
        }
        return Math.max(avg, max);    
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen  = new HashMap<Integer, Integer>();
           int[] result = new int[2];
           for(int i=0;i<nums.length;i++){
               if(!seen.containsKey(target - nums[i])){
                   seen.put(nums[i],i);
               }else{
                   result[0] = i;
                   result[1] = seen.get(target - nums[i]);
               }
           }
           return result;
       }
    
    public int removeElement(int[] nums, int val) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums.length == 0)
        	return 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+ 1);
        }
        if(map.containsKey(val)) {
        	return (nums.length-map.get(val));
        }
        return 0;
    }
    
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        if(m==0 && n>0){
            nums1 = nums2;
            return;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(j<n && i<m){
            if(nums1[i] < nums2[j]){
                i++;
            }else{
                //Move elements from i to m == i+1 to m+1 
                int t = m;
                while(t > i){
                    nums1[t] = nums1[--t];
                    
                }
                nums1[i] = nums2[j];
                j++;
            }
        }
        while(j<n){
            nums1[m] = nums2[j];
            m++;
            j++;
        }
    }
    
    public void maximumSubArray(int[] nums,int n) {
    	int ans = Integer.MIN_VALUE;
    	int sum = 0;
    	for(int sub_index = 1;sub_index<=n;sub_index++) {
    		for(int start=0;start<n;start++) {
    			if(sub_index+start > n)
    				break;
    			for(int i=start;i<(start+sub_index);i++) {
    				sum += nums[i];
    			}
    			ans = Math.max(ans, sum);
    			sum = 0;
    		}
    	}
    	System.out.println(ans);
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length-2;i++) {
        	for(int j=i+1;j<nums.length-1;j++) {
        		for(int k=j+1;k<nums.length;k++) {
        			int sum = nums[i] + nums[j] + nums[k];
        			if(sum == 0) {
        				int min = Math.min(nums[i], nums[j]);
        				
        				inner.add(nums[i]);
        				inner.add(nums[j]);
        				inner.add(nums[k]);
        				if(!list.contains(inner))
        				       list.add(inner);
        				//list.add(inner);
        				inner = new ArrayList<Integer>();
        			}
        			
        				
        		}
        	}
        }
        return list;
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length-1;i++) {
        	HashSet<Integer> set = new HashSet<Integer>();
        	for(int j=i+1;j<nums.length;j++) {
        		if(set.contains(-(nums[i] + nums[j]))) {
        			inner.add(nums[i]);
        			inner.add(nums[j]);
        			inner.add(-(nums[i] + nums[j]));
        			if(!list.contains(inner))
        				list.add(inner);
        			inner = new ArrayList<Integer>();
        		}else {
        			//System.out.println(nums[j]);
        			set.add(nums[j]);
        		}
        	}
        }
        return list;
    }
    
    public List<List<Integer>> threeSum2(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length-1;i++) {
        	int l = i+1;
        	int r = nums.length-1;
        	while(l < r) {
        		int sum = nums[i] + nums[l] + nums[r];
        		if(sum == 0) {
        			inner.add(nums[i]);
        			inner.add(nums[l]);
        			inner.add(nums[r]);
        			if(!list.contains(inner))
        				list.add(inner);
        			inner = new ArrayList<Integer>();
        			l++;
        			r--;
        		}else if(sum < 0 )
        			l++;
        		else
        			r--;
        	}
        }
        return list;
    }
    
    
    public int maximumSwap(int num) {
    	char[] digits = Integer.toString(num).toCharArray();
    	int[] buckets = new int[10];
    	
    	for(int i=0;i<digits.length;i++) {
    		buckets[digits[i] - '0'] = i;
    	}
    	
    	for(int i=0;i<digits.length;i++) {
    		for(int k=9; k> digits[i]-'0' ;k--) {
    			if(buckets[k] > i) {
    				char temp = digits[i];
    				digits[i] = digits[buckets[k]];
    				digits[buckets[k]] = temp;
    				return Integer.valueOf(new String(digits));
    			}
    		}
    	}
    	return num;
    }
    
    
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++) {
        	if(!map.containsKey(nums[i])) {
        		map.put(nums[i], 1);
        	}else{
        		res[0] = nums[i];
        		res[1] = nums[i] + 1; 
        	}
        	
        }
        return res;
        	
    }	
    
    public int longestPalindrome(String s) {
        int left = 0,right = s.length()-1;
        int max = 0;
        if(s.length() == 1)
        	return 1;
        while(left < right) {
        	if(checkPalindrome(s,left,right)) {
        		int len = right - left + 1;
        		max = Math.max(len, max);
        	}
        	if(checkPalindrome(s,left+1,right) || checkPalindrome(s,left,right-1)) {
        		int len = right - left ;
        		max = Math.max(len, max);
        	}
        	left++;
        	//right--;
        }
        return max;
    }
    
    public boolean checkPalindrome(String s, int start, int end) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	int strLen = end - start+1;
    	for(int i=start;i<=end;i++) {
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+ 1);
    	}
    	int odd=0,even =0;
    	for(Map.Entry<Character, Integer> m : map.entrySet()) {
    		if(m.getValue()%2 == 0)
    			even++;
    		else
    			odd++;
    	}
    	
    	if(strLen%2 !=0 && odd == 1 ) {
    		return true;
    	}else if(strLen%2 == 0  && even>0 && odd == 0) {
    		return true;
    	}
    	return false;
    }
    
   public int repeatedStringMatch(String A, String B) {
        int len_A = A.length();
        int len_B = B.length();
        int count = 0;
        
        
        int first = B.indexOf(A.charAt(0));
        
        
        while(A.length() < B.length()) {
        	A += A;
        	count++;
        }
        
        
        while(true) {
        	if(A.length() == B.length() && A.equals(B))
        		return count;
        	for(int i=0;i<A.length()-B.length();i++) {
        		if(A.substring(i, i+B.length()).equals(B)) {
        			return count;
        		}
        	}
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonDecreasingArray d = new NonDecreasingArray();
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		//System.out.println(d.checkPossibility(a));
		//System.out.println(d.findMaxAverage(a, 2));
		//System.out.println(d.removeElement(a, 3));
		System.out.println();
		//d.maximumSubArray(a, a.length);
		int[] nums = {-1, 0, 1, 2, -1, -4};
		//System.out.println(d.threeSum(nums));
		//System.out.println(d.threeSum2(nums));
		//System.out.println(d.maximumSwap(1772));
		
//		int[] a1 = {1,2,2,4};
//		System.out.println();
//		int[] r = d.findErrorNums(a1);
//		for(int i:r) {
//			System.out.print(i+" ");
//		}
		
		
		System.out.println(d.longestPalindrome("abccccdd"));
	}

}
