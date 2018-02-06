import java.util.*;
public class Solution {
    public static int singleNonDuplicate(int[] nums) {
    		int res = nums[0];
        for(int i=1;i<nums.length;i++) {
        		res ^= nums[i];
        }
        return res;
    }
    
    public String largestNumber(int[] nums) {
        List<String> slist = new ArrayList<String>();
        
        for(int i=0;i<nums.length;i++){
            slist.add(String.valueOf(nums[i]));
        }
        
        Collections.sort(slist, new Comparator(){
            @Override
            public int compare(String x, String y){
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx) > 0 ? -1 :1;
            }
        });
        
        StringBuffer buff = new StringBuffer();
        for(String s: slist){
            buff.append(s);
        }
        return buff.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));
	}

}
