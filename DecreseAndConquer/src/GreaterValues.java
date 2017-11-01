
public class GreaterValues {

	public int findGreaterValues(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		
		while(start <= end) {
			int mid =  (start + end)/2;
			if(nums[mid] ==  target) {
				while((mid+1) <= (nums.length-1) && nums[mid+1] == target)
					mid +=1;
				return (nums.length-1) - mid;
			}else if(nums[mid] > target)
				end = mid - 1;
			else 
				start = mid + 1;
		}
		return (nums.length-1) - start-1 ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  {2,6,6,6,7,8,9};
		GreaterValues g = new GreaterValues();
		System.out.println(g.findGreaterValues(nums, 2));
	}

}
