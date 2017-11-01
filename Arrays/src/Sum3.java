import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sum3 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        Set<Integer> seen = new HashSet<Integer>();
        
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		int target  = nums[i] + nums[j];
        		if(seen.contains(-target)) {
        			int[] a = minArray(nums[i],nums[j],-target);
        			inner.add(a[0]);
        			inner.add(a[1]);
        			inner.add(a[2]);
        			if(!outer.contains(inner))
        				outer.add(inner);
        			inner = new ArrayList<Integer>();
        			//seen = new HashSet<Integer>();
        		}else {
        			seen.add(nums[j]);
        		}
        	}
        	seen = new HashSet<Integer>();
        }
        return outer;
    }
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		List<Integer> inner  = new ArrayList<Integer>();
        Arrays.sort(nums);
        
        Set<Integer> seen = new HashSet<Integer>();
        
        for(int i=0;i<nums.length-3;i++) {
        	for(int j=i+1;j<nums.length-2;j++) {
        		for(int k=j+1;k<nums.length-1;k++) {
        			for(int m=k+1;m<nums.length;m++) {
        				int sum = nums[i] + nums[j] + nums[k] + nums[m];
        				if(sum == target) {
        					inner.add(nums[i]);
        					inner.add(nums[j]);
        					inner.add(nums[k]);
        					inner.add(nums[m]);
        					if(!outer.contains(inner))
                				outer.add(inner);
                			inner = new ArrayList<Integer>();
        				}
        			}
        		}
        	}
        }
        return outer;
    }		
	
	public int[] plusOne(int[] digits) {
        int t = 1;
        int carry = 0;
        int[] newArr = digits;
        for(int i=digits.length-1; i>=0;i--) {
        	if(digits[i] == 9 && (carry == 1 || t == 1)) {
        		digits[i] = (digits[i] + t + carry)%10;
        		t = 0;
        		carry = 1;
        	}else {
        		
        		if(i == digits.length-1)
        			digits[i] = digits[i] + t;
        		else if(carry == 1)
        			digits[i] = digits[i] + carry + t;
        		t = 0; 
        		carry = 0;
        	}
        }
        if(carry == 1) {
        	newArr = new int[digits.length + 1];
        	for(int i=0;i<digits.length;i++) {
        		newArr[i+1] = digits[i];
        	}
        	newArr[0] = 1;
        }
        return newArr;
    }
	
	public int[] minArray(int a, int b,int c){
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		return arr;
	}
	
	public int maximumProduct(int[] nums) {
		if(nums.length <  3)
			return 0;
        Arrays.sort(nums);
        int n = nums.length-1;
        return Math.max(nums[0] * nums[1] * nums[n], nums[n-2] * nums[n-1] * nums[n]);
    }
	
	public boolean checkPossibility(int[] nums) {
        int[] one  = nums.clone();
        int[] two = nums.clone();
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                one[i] = nums[i+1];
                two[i+1] = nums[i];
            }
        }
        int[] oneTemp = one.clone();
        int[] twoTemp = two.clone();
        Arrays.sort(one);
        Arrays.sort(two);
        return (Arrays.equals(one, oneTemp) || Arrays.equals(two, twoTemp));
    }
	
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-3;i++) {
			for(int j=i+1;j<nums.length-2;j++) {
				int l = j+1;
				int r = nums.length-1;
				
				while(l <  r) {
					if(nums[i] + nums[j] + nums[l] + nums[r] == target) {
						inner.add(nums[i]);
						inner.add(nums[j]);
						inner.add(nums[l]);
						inner.add(nums[r]);
						if(!outer.contains(inner))
							outer.add(inner);
						inner = new ArrayList<Integer>();
						l++;
						r--;
					}else if(nums[i] + nums[j] + nums[l] + nums[r] < target) {
						l++;
					}else
						r--;
				}
			}
		}
		return outer;
	}
	
	public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(max2 < nums[i] && nums[i]!=max1){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i]!=max2 && nums[i]!=max1){
                max3 = nums[i];
            }
        }
        if(max3 == Integer.MIN_VALUE)
            return max1;
        return max3;
    }
	
	
	
	public int repeatedStringMatch(String A, String B) {
        StringBuffer buffA = new StringBuffer(A);
        int count = 1;
        while(buffA.indexOf(B)==-1) {
        	buffA.append(A);
        	count++;
        }
       // System.out.println(buffA.indexOf(B));
        return count==1?-1:count;
    }
	
	public int countPrimes(int n) {
		if(n==0 || n==1)
			return 0;
		int count = 0;
		for(int i=2;i<n;i++) {
			if(checkPrime(i))
				count++;
		}
		return count;
    }
	
	
	public void rotate(int[] nums, int k) {
        int n = nums.length-1;
        if(n+1>1){
            while(k!=0){
            int temp = nums[n];
            for(int i=n;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
        }
        
    }
	public boolean checkPrime(int n) {
		if(n==2)
			return true;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	public int reverse(int x) {
        int n = x;
        int new_n =0;
        while(n!=0){
            int rem = n%10;
            new_n = new_n * 10 + rem;
            System.out.println(new_n);
            System.out.println(n);
            n = n/10;
            System.out.println(n);
            System.out.println("\n");
        }
        return new_n;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum3 s = new Sum3();
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		List<List<Integer>> l = s.threeSum(nums);
//		Iterator it = l.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		System.out.println("4Sum");
//		List<List<Integer>> l1 = s.fourSum1(nums, 0);
//		Iterator it1 = l1.iterator();
//		while(it1.hasNext()) {
//			System.out.println(it1.next());
//		}
//		
//		int[] digits = {1,0};
//		int[] res = s.plusOne(digits);
//		for(int i=0;i<res.length;i++)
//			System.out.print(res[i] + " ");
//		System.out.println();
//		
//		int[] nums1 = {-4,-3,-2,-1,60};
//		
//		System.out.println(s.checkPossibility(nums1));
//		
//		System.out.println("Max Product");
//		int[] a = {-4,-3,-2,-1,60};
//		System.out.println(s.maximumProduct(a));
//		
//		int[] arr = {1,2,-2147483648};
//		System.out.println(s.thirdMax(arr));
//		
//		System.out.println(s.repeatedStringMatch("aa" , "a"));
//		//System.out.println(s.reverse(1534236469));
//		
//		System.out.println(s.countPrimes(499979));
//		int[] n = {1,2};
//		s.rotate(n, 3);
//		
		//System.out.println(s.repeatedStringMatch1("abcabcabcabc", "abac"));
		List<List<Integer>> lis = s.generate(1);
		Iterator it2 = lis.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		List<Integer> list1 = s.getRow(0);
		Iterator il = list1.iterator();
		System.out.println(list1);
		while(il.hasNext()) {
			System.out.println(il.next());
		}
		
		System.out.println(s.reverseWords("   a   b "));
	}
	
	
	public List<List<Integer>> generate(int numRows) {
        List<Integer> inner = new ArrayList<Integer>();
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        
        int[] arr = {1};
        int[] new_arr = new int[arr.length+1];
        
        if(numRows>= 1) {
        	inner.add(1);
            outer.add(inner);
            inner = new ArrayList<Integer>();
            while(numRows >=2){
            	new_arr = new int[arr.length+1];
                inner.add(1);
                new_arr[0] = 1;
               // outer.add(inner);
                for(int j=1;j<arr.length;j++){
                    int t = arr[j-1] + arr[j];
                    new_arr[j] = t;
                    inner.add(t);
                }
                new_arr[new_arr.length-1] = 1;
                inner.add(1);
                outer.add(inner);
                arr = new_arr;
                inner = new ArrayList<Integer>();
                numRows--;
        }
        
        }
        return outer;
	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> inner = new ArrayList<Integer>();
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        
        int[] arr = {1};
        int[] new_arr = new int[arr.length+1];
        int temp = 0;
        
//        	int temp = 1;
        	inner.add(1);
            outer.add(inner);
            if(rowIndex == 0)
            	return inner;
            //inner = new ArrayList<Integer>();
            while(temp !=rowIndex){
            	inner = new ArrayList<Integer>();
            	new_arr = new int[arr.length+1];
                inner.add(1);
                new_arr[0] = 1;
               // outer.add(inner);
                for(int j=1;j<arr.length;j++){
                    int t = arr[j-1] + arr[j];
                    new_arr[j] = t;
                    inner.add(t);
                }
                new_arr[new_arr.length-1] = 1;
                inner.add(1);
                outer.add(inner);
                arr = new_arr;
                
                temp++;
        }
        
        
        return inner;
    }
	
	
	public String reverseWords(String s) {
		s = s.trim();
		s.replaceAll(" ", "");
		String[] sarr = s.split(" ");
        StringBuffer buff = new StringBuffer();
		
        if(sarr.length > 0) {
        	int i=0,j=sarr.length-1;
    		while(i < j) {
    			String temp = sarr[j].trim();
    			sarr[j] = sarr[i].trim();
    			sarr[i] = temp;
    			i++;
    			j--;
    		}
    		for(int k=0;k<sarr.length;k++) {
    			buff.append(sarr[k]);
    			buff.append(" ");
    		}
    		buff.deleteCharAt(buff.length()-1);
    		return buff.toString();
        }
		return s;
    }
}
