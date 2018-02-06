import java.util.*;
public class Solution {
	
	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(Integer i : A)
            list.add(i);
        int count =0;
         for(Integer i : list){
             if(list.get(Math.abs(i) - 1) < 0){
                 res.add(Math.abs(i));
                 res.add(count);
             }else{
                 list.set(Math.abs(i)-1, -list.get(Math.abs(i) -1));
             }
             count++;
         }
         return res;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 1, 2, 5, 1};
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++)
			l.add(nums[i]);
		ArrayList<Integer> res = repeatedNumber(l);
		for(Integer i : res)
			System.out.println(i);
	}

}
