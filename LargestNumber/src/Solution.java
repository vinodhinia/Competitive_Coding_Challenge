import java.util.Collections;
import java.util.*;

public class Solution {
	
	
	
	public static String largestNumber(int[] nums) {
		List<String> sarr = new ArrayList<String>();
		int j=0;
		for(int i: nums) {
			sarr.add(String.valueOf(i));
		}
		
        Collections.sort(sarr, new Comparator<String>() {
        	
        	@Override
        	public int compare(String x, String y) {
        		String xy = x + y;
        		String yx = y+ x;
        		return xy.compareTo(yx) > 0? -1 : 1;
        	}
        });
        StringBuffer buff = new StringBuffer();
        for(String s : sarr)
        		buff.append(s);
        
        String str = String.valueOf(Integer.parseInt(buff.toString()));

        return str;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9, 99, 999, 9999, 9998};
		System.out.println(largestNumber(nums));
	}

}
