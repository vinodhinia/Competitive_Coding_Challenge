import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElem {
	
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length,Collections.reverseOrder());
		
		for(int n:nums)
			pq.add(n);
		for(int i=1;i<k;i++) {
			pq.remove();
		}
		return pq.peek();
		
	}
	
	public int quickSelect(int[] nums, int start , int end, int k) {
		k = nums.length-k;
		while(true) {
			if(start <= end) {
				int pIndex =  partition(nums, start, end);
				if(k == pIndex)
					return nums[k];
				if(pIndex < k) {
					start = pIndex + 1;
				}else {
					end = pIndex -1;
				}
			}
		}
	}
	
	public int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int pIndex = start;
		
		for(int i=start;i<=end;i++) {
			if(nums[i] < pivot) {
				nums = swap(nums, i, pIndex);
				pIndex++;
			}
			
		}
		nums = swap(nums, pIndex, end);
		return pIndex;
	}
	
	public int[] swap(int[] nums, int x, int y) {
		int t = nums[x];
		nums[x]= nums[y];
		nums[y] = t;
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 4, 2, 5, 12, 9};
		KthLargestElem k = new KthLargestElem();
		System.out.println(k.findKthLargest(nums, 3));
		
		System.out.println(k.quickSelect(nums, 0, nums.length-1, 3));
	}

}
