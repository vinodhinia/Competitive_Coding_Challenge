import java.util.*;

public class Solution {

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int start = 0, end =0;
		
		for(int i=0;i<A.size()-1;i++) {
			if(A.get(i) > A.get(i+1)) {
				start = i;
				break;
			}
		}
		
		for(int i=A.size()-1; i>=1; i--) {
			if(A.get(i) < A.get(i-1)) {
				end = i;
				break;
			}
		}
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=start;i<=end;i++) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}
		for(int i=0;i<start;i++) {
			if(min < A.get(i)) {
				start = i;
				break;
			}
		}
		
		for(int j=end+1;j<A.size()-1;j++) {
			if(max > A.get(j)) {
				end = j;
				break;
			}
				
		}
		
		
		if(start == 0 && end ==0) {
			list.add(-1);
			return list;
		}
			
		
		list.add(start);
		list.add(end);
		
		
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<n.length;i++)
			l.add(n[i]);
		ArrayList<Integer> list = subUnsort(l);
		for(Integer i : list)
			System.out.println(i);
	}

}
