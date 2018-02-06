import java.util.*;

public class Solution {
	
	 static String[][] wordCountEngine(String document) {
		    // your code goes here
		    //String[][] result = new String[][];
		    document = document.toLowerCase();
		    document = document.replaceAll("[^a-zA-Z ]", "");
		    String[] sarr = document.split(" ");
		     
		    HashMap<String, Integer> map = new HashMap<String, Integer>();
		    for(int i=0;i<sarr.length;i++){
		      map.put(sarr[i] , map.getOrDefault(sarr[i], 0)+1);
		    }
		    
		    List<String>[] list = new List[sarr.length];
		    
		    System.out.println(list.length);
		    for(Map.Entry<String, Integer> m : map.entrySet()){
		      list[m.getValue()].add(m.getKey());
		    }
		    
		    for(int i=0;i<list.length;i++){
		      List<String> l = list[i];
		      for(String in : l){
		        System.out.println(in);
		      }
		    }
		    return null;
		  }

	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
	 
		return result;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,2,3,4};
		ArrayList<ArrayList<Integer>> res = s.permute(nums);
		
		
	}

}
