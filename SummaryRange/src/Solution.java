import java.util.*;
public class Solution {

	public static List<String> summaryRanges(int[] nums) {
		if(nums.length == 0)
			return new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		int start =0, end = 0;
		
		while(end < nums.length-1) {
			if(nums[end]+1 == nums[end+1])
				end++;
			else {
				if(start!=end) {
					list.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[end]));
				}else {
					list.add(String.valueOf(nums[start]));
				}
				end++;
				start = end;
			}
		}
		
		if(start == end) {
			list.add(String.valueOf(nums[start]));
		}else if(start!=end){
			list.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[end]));
		}
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0,2,4,6};
		List<String> list = summaryRanges(nums);
		for(String l : list) {
			System.out.println(l);
		}
	}

}
