
public class NumberOfOnes {
	
	public int findNumberOfOnes(int[] nums) {
		int start = 0,end = nums.length -1;
		while(start<=end) {
			int mid = (start + end)/2;
			if(nums[mid] == 0) {
				start = mid + 1;
			}else if(nums[mid] == 1 && mid - 1 > 0) {
				if(nums[mid-1] == 0)
					return nums.length - mid;
				end = mid -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,1,1,1,1};
		NumberOfOnes n = new NumberOfOnes();
		System.out.println(n.findNumberOfOnes(nums));
	}

}
