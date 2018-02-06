
public class Solution1 {
	public int solution(int[] A) {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length-1;i++){
            for(int j=A.length-1; j>i;j--){
                if(checkAdjacentPair(A, i, j)){
                	return Math.abs(i-j);
                    //max = Math.max(max, Math.abs(i-j));
                }
            }
        }
        return -1;
    }
    
    public boolean checkAdjacentPair(int[] a, int i, int j){
        int min  = Math.min(a[i], a[j]);
        int max = Math.max(a[i], a[j]);
        for(int m=i;m<=j;m++){
         if(a[m] < max && a[m] > min){
             return false;
        }
        }
        return true;
    }
        
     public static void main(String[] args) {
    	 int[] nums = {0,3,3,7,5,3,11,1};
    	 Solution1 s = new Solution1();
    	 
    	 System.out.println(s.solution(nums));
     }
}
