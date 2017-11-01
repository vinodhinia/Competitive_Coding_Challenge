
public class InsertionSort {
	
	public void insertionSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			int value = nums[i];
			int hole = i;
			while(hole>0 && nums[hole-1] > value) {
				nums[hole] = nums[hole-1];
				hole = hole-1;
			}
			nums[hole] = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
