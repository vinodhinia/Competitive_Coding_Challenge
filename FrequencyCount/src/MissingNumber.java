import java.util.*;
public class MissingNumber {
	
	public int[] findMissingNumber(int[] nums,int n) {
		List<Integer> l = new ArrayList<Integer>();
		int[] newArr = new int[n];
		for(int i:nums) {
			newArr[i-1] = 1;
		}
		for(int i=0;i<newArr.length;i++) {
			if(newArr[i]==0) {
				l.add(i+1);
			}
		}
		int[] res = new int[l.size()];
		Iterator<Integer> it = l.iterator();
		int i=0;
		while(it.hasNext()) {
			res[i++] = it.next();
		}
		return res;
	}

	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		int[] nums = {6, 4, 2, 1};
		int[] r = m.findMissingNumber(nums, 6);
		for(int i: r) {
			System.out.println(i);
		}
	}
}
