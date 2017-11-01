
public class MergeSort {

	
	public int[] sort(int[] nums) {
		int n = nums.length/2;
		if(n < 1)
			return nums;
		int[] left = new int[n];
		int[] right = new int[nums.length - n];
		
		
		int i =0;
		
		for(i=0;i<n;i++) {
			left[i] = nums[i];
		}
		int j=0;
		for(int k =i;k<nums.length;k++) {
			right[j++] = nums[k];
		}
		
		left = sort(left);
		right = sort(right);
		return merge(left,right);
	}
	
	public int[] merge(int[] left, int[] right) {
		int i=0,j=0,k=0;
		int[] merge = new int[left.length + right.length];
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				merge[k++] = left[i++];
			}else {
				merge[k++] = right[j++];
			}
		}
		while(i < left.length) {
			merge[k++] = left[i++];
		}
		while(j < right.length) {
			merge[k++] = right[j++];
		}
		return merge;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,7,9,3,2,1};
		MergeSort m = new MergeSort();
		int[] res = m.sort(nums);
		
		for(int n: res) {
			System.out.print(n + " ");
		}
	}

}
