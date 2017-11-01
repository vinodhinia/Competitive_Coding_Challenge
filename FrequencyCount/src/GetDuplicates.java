import java.util.HashMap;
import java.util.Map.*;
import java.util.*;
public class GetDuplicates {

	public int[] getDuplicates(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n:nums) {
			if(map.containsKey(n)) {
				map.put(n, map.get(n)+1);
			}else {
				map.put(n, 1);
			}
		}
		
		List<Integer> l = new LinkedList<Integer>();
		for(Entry<Integer, Integer> m: map.entrySet()) {
			if(m.getValue()>1)
				l.add(m.getKey());
		}
		
		int[] res = new int[l.size()];
		Iterator<Integer> it = l.iterator();
		
		int i=0;
		while(it.hasNext()) {
			res[i++] = it.next();
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetDuplicates d = new GetDuplicates();
		int[] arr = {1, 2, 3, 4};
		int[] res = d.getDuplicates(arr);
		for(int i:res)
			System.out.print(i + " ");
		
	}

}
