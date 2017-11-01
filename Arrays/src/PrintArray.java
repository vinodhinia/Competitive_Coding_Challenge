import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintArray {

	public static void compute(int[] arr) {
	    // YOUR WORK HERE
		computeHelper(arr,0);
	  }

	  public static void computeHelper(int[] arr, int index) {
	    // YOUR WORK HERE
		  if(index >= arr.length)
			  return;
		  System.out.println(arr[index]);
		  index = index+1;
		  computeHelper(arr,index);
	  }
	  
	  
	  public static void compute1(int[] arr) {
		    // YOUR WORK HERE
		  traverse(arr,arr.length-1);
		  }

		  private static void traverse(int[] arr, int index) {
		    // YOUR WORK HERE
			  if(index < 0)
				  return;
			  System.out.println(arr[index]);
			  index = index-1;
			  traverse(arr,index);
		  }
		  
		  
		  public static String compute(String str) {
			    return computeStringHelper(str,"",str.length()-1);
		  }
		  
		  public static String computeStringHelper(String s,String res, int index) {
			  if(index < 0)
				  return res;
			  res += s.charAt(index);
			  index = index -1;
			  return computeStringHelper(s, res, index);
		  }
		  
		  public void printString(String str,int index) {
			  if(index <0)
				  return;
			  System.out.print(str.charAt(index));
			  index = index - 1;
			  printString(str,index);
		  }
		  
		  public static int[][] compute2(int[] arr) {
			    // YOUR WORK HERE
			  int rows =0;
			  if(arr.length%2 == 0)
				  rows = arr.length/2;
			  else
				  rows = arr.length/2 + 1;
			  int[][] outer = new int[rows][2];
			  int[] subArr = new int[2];
			  Arrays.fill(subArr, -1);
			  
			   return new int[0][0];
		  }
		  
		  public static int[] compute2D(int[] arr,int[] subArr, int index) {
			  if(index >= arr.length)
				  return subArr;
			  
			  
			  
			  return new int[0];
		  }
		  
		  
		public static int[] compute(int[] arr1, int[] arr2) {
			    // YOUR WORK HERE
			  int left = 0, right = 0;
			  int[] res = new int[arr1.length + arr2.length];
			  res =  computeMergeHelper(arr1,arr2, res, 0,0,0); 
			  return res;
		}
		  
		public static int[] computeMergeHelper(int[] arr1, int[] arr2, int[] result,int i, int left,int right) {
			if(left >= arr1.length && right >=arr2.length) {
				int[] res = {left,right};
				return result;
			}
			if(left < arr1.length && right < arr2.length) {
				if(arr1[left] <= arr2[right]) {
					result[i] = arr1[left];
					left++;i++;
				}else if(arr1[left] > arr2[right]){
					result[i] = arr2[right];
					right++;i++;
				}
//				computeMergeHelper(arr1,arr2,result,i,left,right);
			}
			
			
			if(left < arr1.length && right >= arr2.length) {
				result[i] = arr1[left];
				left++;i++;
			}
			if(right< arr2.length && left >= arr1.length) {
				result[i] = arr2[right];
				right++;i++;
			}
			return computeMergeHelper(arr1,arr2,result,i,left,right);
			
		}
		
		public static int compute(int a, int b) {
		    // YOUR WORK HERE
			
		    return computePower(a,1,b);
		  }
		
		public static int computePower(int a,int res, int b) {
			if(b==0)
				return res;
			res = res * a;
			return computePower(a, res , b-1);	
		}
		
		
		public int[] flatten(int[] arr) {
			int[] result=null;
			List<Integer> l = new ArrayList<Integer>();
			
			l = flatternHelper(arr,l);
			return result;
					
		}
		
		public List<Integer> flatternHelper(int[] arr,List<Integer> list){
			for(int i=0;i<arr.length;i++) {
				if(!Character.isDigit(arr[i])) {
					flatternHelper(arr, list);
				}else {
					list.add(arr[i]);
				}
			}
			return null;
		}
		  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintArray p = new PrintArray();
		int[] nums = {1,2,3};
		p.compute(nums);
		p.compute1(nums);
		String s = "hello";
		p.printString(s,s.length()-1);
		
		System.out.println("\n");
		System.out.println(compute(s));
		
		int[] arr1 = {1, 4, 7};
		int[] arr2 = {2, 3, 6, 9};
		int[] res =  p.compute(arr1, arr2);
		
		for(int i: res) {
			System.out.print(i + " ");
		}
		
		System.out.println("Power");
		System.out.println(p.compute(3, 4));
		System.out.println(Character.isDigit(arr1[0]));
	}

}
