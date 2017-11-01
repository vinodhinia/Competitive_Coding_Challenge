
public class SubArraySort {
	
	public static int subArraySort(int[] nums) {
		int i=0,j=1;
		int start =0,end = nums.length-1;
		
		for(j=1;j<nums.length;j++) {
			if(nums[j-1] > nums[j]) {
				start = j;
				break;
			}
		}
		
		for(int k=nums.length-2;k>=1;k--) {
			if(nums[k] > nums[k+1]) {
				end = k+1;
				break;
			}
		}
		
		int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		for(int k=start;k<=end;k++) {
			min = Math.min(nums[k], min);
			max = Math.max(nums[k], max);
		}
		
		int[] res = new int[2];
		for(int m=0;m<=start;m++) {
			if(nums[m] >= min) {
				res[0] = m;
			}
		}
		
		for(int k=end;k<nums.length;k++) {
			if(nums[k] <= max) {
				res[1] = k;
			}
		}
		if(res[0] == 0 && res[1] == 0)
		{
			return 0;
		}
			
//		System.out.println(res[1] - res[0]+1);
//		System.out.println(res[0] +" "+ res[1]);
		return res[1] - res[0]+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,3,2,4};
		System.out.println(subArraySort(nums));
	}

}
