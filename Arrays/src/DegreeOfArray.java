
public class DegreeOfArray {
	
	public int findShortestSubArray(int[] nums) {
        int max = 1,count =1;
        for(int i=0;i<nums.length-1;i++) {
        	if(nums[i] == nums[i+1]) {
        		count++;
        	}else {
        		max = Math.max(max, count);
        		count = 1;
        	}
        }
        return max;
    }
	
	public static int[] selection(int[] input) {
	    // YOUR WORK HERE
	    for(int i=0;i<input.length-1;i++) {
				int imin = i;
				for(int k=i+1;k<input.length;k++) {
					if(input[k] < input[imin]) {
						imin = k;
					}
				}
				int temp = input[imin];
				input[imin] = input[i];
				input[i] = temp;
			}
	    
	    for(int n: input) {
	    	System.out.print(n+ " ");
	    }
	    return input;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1,3,1};
		DegreeOfArray d = new DegreeOfArray();
		//System.out.println(d.findShortestSubArray(nums));
		int[] num = {5,1,8,4,3};
		selection(num);
		
	}

}
