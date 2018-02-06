import java.util.*;

public class Solution {
	
	static String[][] wordCountEngine(String document) {
	    // your code goes here
	    document = document.toLowerCase();
	    document = document.replaceAll("[^a-zA-Z ]", "");
	    String[] sarr = document.split(" ");
	     
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for(int i=0;i<sarr.length;i++){
	      map.put(sarr[i] , map.getOrDefault(sarr[i], 0)+1);
	    }
	    
	    List<String>[] list = new List[sarr.length];
	    
	    for(Map.Entry<String, Integer> m : map.entrySet()){
	    	if(list[m.getValue()] == null) {
	    		List<String> bucketList = new ArrayList<String>();
	    		bucketList.add(m.getKey());
	    		list[m.getValue()] = bucketList;
	    	}else {
	    		list[m.getValue()].add(m.getKey());
	    	}
	    }
	    
	    String[][] stringArr = new String[map.size()][2];
	    int ac =0;
	    for(int i=list.length-1;i >= 0;i--){
	      if(list[i] !=null) {
	    	  List<String> r = list[i];
	    	  if(r.size() > 1) {
	    		  Collections.sort(r);
	    	  }
	    	  for(String s : r) {
    			  stringArr[ac][0] = s;
    			  stringArr[ac][1] = Integer.toString(i);
    			  ac++;
    		  }
	    	  
	      }
	    }
	    return stringArr;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		String[][] res = wordCountEngine(document);
		for(String[] r : res) {
			for(String s: r) {
				System.out.print(s +" ");
			}
			System.out.println();
		}
	}

}
