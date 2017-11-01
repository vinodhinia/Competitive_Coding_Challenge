
public class NumberOfOnes {

	public int findNumberOfOnes(int[] nums) {
		int start = 0,end = nums.length-1;
		while(start < end) {
			int mid = (start + end)/2;
			if(nums[mid] == 1 && nums[mid-1] == 0)
				return (nums.length - mid);
			else if(nums[mid] == 0)
				start = mid + 1;
			else
				end = mid -1;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfOnes n = new NumberOfOnes();
		int[] nums = {0};
		System.out.println(n.findNumberOfOnes(nums));
	}

}
