
public class SortedAndRotatedArray {

	public int search(int[] nums, int target) {
	    int left = 0;
	    int right= nums.length-1;
	 
	    while(left<=right){
	        int mid = left + (right-left)/2;
	        if(target==nums[mid])
	            return mid;
	 
	        if(nums[left]<=nums[mid]){
	            if(nums[left]<=target&& target<nums[mid]){
	                right=mid-1;
	            }else{
	                left=mid+1;
	            }
	        }else{
	            if(nums[mid]<target&& target<=nums[right]){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }    
	    }
	 
	    return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {35, 46, 79, 102, 1, 14, 29, 31};
		int target = 47;
		SortedAndRotatedArray s = new SortedAndRotatedArray();
		System.out.println(s.search(nums, target));
	}

}
