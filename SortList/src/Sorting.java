
public class Sorting {
	
	public void bubble(int[] nums) {
		for(int j=0;j<nums.length;j++) {
		for(int i =1;i<nums.length;i++) {
			if(nums[i-1] > nums[i]) {
				int temp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = temp;
			}
		}
		}
		
		for(int k : nums) {
			System.out.print(k  + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,9,8,6,3,1,4,2,2,2};
		Sorting s = new Sorting();
		s.bubble(nums);
	}

}
