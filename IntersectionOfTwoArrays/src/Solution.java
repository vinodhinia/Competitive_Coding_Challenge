import java.util.*;

public class Solution {
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        int p1 = nums1.length-1;
        int p2 = nums2.length -1;
        int i=0,j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<Integer>();
        
        while(i <= p1 && j<=p2){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }else if(nums2[j] < nums1[i]){
                j++;
            }
        }
        int it = 0;
        int[] res = new int[result.size()];
        for(Integer r: result){
            res[it++] = r;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,7,9,7,6,7};
		int[] nums2 = {5,0,0,6,1,6,2,2,4};
		
		int[] res = intersect(nums1, nums2);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}

}
