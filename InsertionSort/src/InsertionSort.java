
public class InsertionSort {
	
	public int[] insertionSort(int[] nums) {
		//int n = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i] < nums[i-1]) {
				int n = nums[i];
				int k =0;
				for(k=i;k>0;k--) {
					if(nums[k-1] > n) {
						nums[k] = nums[k-1];
					}
					else {
						break;
					}
				}
				nums[k] = n;
				
			}
		}
		return nums;
	}

	
	public static int[] selection(int[] input) {
	    // YOUR WORK HERE
		
		for(int i=0;i<input.length-1;i++) {
			int imin = i;
			for(int k=i+1;k<input.length;k++) {
				if(input[k] < input[i]) {
					imin = k;
				}
			}
			int temp = input[imin];
			input[imin] = input[i];
			input[i] = temp;
		}
		
		for(int m: input)
			System.out.print(m + " ");
	    return input;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,4,2,5,1,3};
		InsertionSort in = new InsertionSort();
		int[] n = in.insertionSort(nums);
		for(int i:n)
			System.out.println(i);
		
		in.selection(nums);
	}

}
