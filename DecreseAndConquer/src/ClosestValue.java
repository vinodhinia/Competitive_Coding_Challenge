
public class ClosestValue {
	
	public int findClosestValue(int[] nums,int target) {
		int start = 1,end = nums.length -1;
		while(start < end) {
			int mid = (start + end)/2;
			if(nums[mid] < target) {
				if(nums[mid+1] > target) {
					if(Math.abs(nums[mid+1] - target) < Math.abs(nums[mid] -target)) {
						return nums[mid+1];
					}else if(Math.abs(nums[mid+1] - target) >= Math.abs(nums[mid] -target)){
						return nums[mid];
					}
				}
				start = mid + 1;
			}else {
				end = mid;
				
			}
				
			
		}
		return nums[end];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestValue c = new ClosestValue();
		int[] nums = {1,2,3};
		System.out.println(c.findClosestValue(nums, 8));
	}

}
