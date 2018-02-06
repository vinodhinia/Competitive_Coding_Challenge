
public class Solution {
	
	public static int findOnes(int[] nums) {
		int left =0, right=nums.length-1;
		//1, 1, 1, 1, 1, 1
		//0  1  2  3  4  5
		//l  r  M        r
		while(left <= right) {
			int mid = (left + right)/2;
			if(mid == 0 && nums[mid] == 1 ||(mid-1>=0 && nums[mid-1] == 0 && nums[mid] == 1)) {
				return nums.length - mid;
			}else if(nums[mid] == 0){
				left =mid+1;
			}else if(mid-1 >=0 && nums[mid] == 1 && nums[mid-1] ==1) {
				right = mid -1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0};
		System.out.println(findOnes(nums));
	}

}
