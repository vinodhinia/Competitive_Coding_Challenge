import java.util.*;

public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int start = 0, end = 0;
		int size = 0;
		int max = 0;
		int sum =0;
		while(end <= A.size()-1) {
			if(A.get(end) >=0) {
				sum += A.get(end);
				end++;
			}else {
				if(sum >0 && max >0 && max == sum) {
					if(end - start > size) {
						res = new ArrayList<Integer>(A.subList(start, end));
						max = sum;
						size = end - start;
						//start = end;
						sum = 0;
					}
				}else if(sum >0 && max >0 && sum > max){
					res = new ArrayList<Integer>(A.subList(start, end));
					size = Math.max(size, end - start);
					max = Math.max(max, sum);
					start = end;
					sum = 0;
				}else {
					end++;
					start++;
				}
			}
		}
		
		if(start!=end) {
			if(max == sum) {
				if(end - start > size) {
					res = new ArrayList<Integer>(A.subList(start, end));
				}
			}else if(sum > max){
				res = new ArrayList<Integer>(A.subList(start, end));
				
			}
		}
		
		return res;
    }
	
	
	public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int index = 1;
        for(Integer a : A){
        	if(a == A.size() - index && (index == A.size() || index < A.size() && a < A.get(index)))
             return 1;
        	
        index++;
        }
        return -1;
    }
	
	
	static int shiftedArrSearch(int[] shiftArr, int num) {
	    // your code goes here
	    int start = 0;
	    for(int i=1;i<shiftArr.length;i++){
	      if(shiftArr[i-1] > shiftArr[i]){
	        start = i;
	        break;
	      }
	    }
	      
	      if(num == shiftArr[start])
	        return start;
	      
	      int left=0, right = shiftArr.length-1;
	      if(start-1 >=0 && shiftArr[0] <= num && num <= shiftArr[start-1] ){
	        left = 0;
	        right = start -1;
	      }
	      else if(shiftArr[start] <= num && num <= shiftArr[right]){
	        left=start;
	        right = shiftArr.length-1;
	      }
	      
	      while(left <=right){
	        int mid = (left + right)/2;
	        if(shiftArr[mid] == num)
	          return mid;
	        else if(shiftArr[mid] > num)
	          right = mid -1;
	        else 
	          left = mid + 1;
	      }
	      
	    
	    return -1;
	  }

	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a =  { -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };

		ArrayList<Integer> l = new ArrayList<Integer>();
//		for(int i=0;i<a.length;i++) {
//			l.add(a[i]);
//		}
		l.add(5);
		l.add(2);
		l.add(6);
//		l.add(0);
//		l.add(9);
//		l.add(3);
//		l.add(6);
//		l.add(0);
//		l.add(6);
//		 ArrayList<Integer> res = s.maxset(l);
//		 for(Integer r : res)
//			 System.out.println(r);
//		 System.out.println(res.size());
		
		//System.out.println(s.solve(l));
		int[] arr = {9,10,12,2,4,5};
//		System.out.println(shiftedArrSearch(arr, 2));
//		System.out.println(shiftedArrSearch(arr, 9));
//		System.out.println(shiftedArrSearch(arr, 10));
//		System.out.println(shiftedArrSearch(arr, 12));
//		System.out.println(shiftedArrSearch(arr, 4));

		//System.out.println(shiftedArrSearch(arr, 5));
		int[] arr1 = {1,2};
		System.out.println(shiftedArrSearch(arr1, 2));
		
	}
}
