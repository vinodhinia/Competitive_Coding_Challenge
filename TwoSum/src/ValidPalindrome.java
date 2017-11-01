import java.util.*;
import java.util.Set;

public class ValidPalindrome {

	public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }

        if (i >= j) return true;

        if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) return true;
        return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            }
            else return false;
        }
        return true;
    }
    
    
    
static int numberOfPairs(int[] a, long k) {
        
        List<Long> inner = new ArrayList<Long>();
        List<List<Long>> outer = new ArrayList<List<Long>>();
        
        Set<Long> seen  = new HashSet<Long>();
        
        for(int i=0;i<a.length;i++){
            long target = k - a[i];
            if(!seen.contains(target)){
                seen.add((long)a[i]);
            }else{
                inner.add(Math.min(a[i], k-a[i]));
                inner.add(Math.max(a[i], k-a[i]));
              
                if(!outer.contains(inner)){
                    outer.add(inner);
                }
                inner = new ArrayList<Long>();
            }
        }
        
        
        return outer.size();
    }

public int maxDifference(int[] a) {
    int min_price = a[0];
    int max_profit = a[1] -a[0];
    for(int i=1;i<a.length;i++){
        int potential_profit = a[i] - a[i-1];
        min_price = Math.min(min_price, a[i]);
        max_profit = Math.max(max_profit,potential_profit);
    }
    return max_profit;
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome p = new ValidPalindrome();
//		System.out.println(p.validPalindrome("abca"));
//		//int[] n = {6,6,3,9,3,5,1};
//		int[] n = {};
//		System.out.println("Number     ");
//		System.out.println(numberOfPairs(n,47));
		int[] n = {2,3,10,2,4,8,1};
		System.out.println(p.maxDifference(n));
	}

}
