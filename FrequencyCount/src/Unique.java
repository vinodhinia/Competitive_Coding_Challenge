import java.util.*;
import java.util.Map.Entry;

public class Unique {
	
	public int[] unique(int[] nums) {
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for(int n:nums) {
			if(map.containsKey(n))
				map.put(n, map.get(n)+1);
			else
				map.put(n,1);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getValue()==1)
				list.add(m.getKey());
		}
		int[] result = new int[list.size()];
		Iterator<Integer> it = list.iterator();
		
		int i=0;
		while(it.hasNext()) {
			result[i++] = it.next();
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unique u = new Unique();
		int[] a = {1, 2, 3, 1, 2};
		int[] r = u.unique(a);
		
		for(int i:r) {
			System.out.println(i);
		}
	}

}
