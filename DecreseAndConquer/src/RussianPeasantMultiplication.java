import java.util.*;
import java.util.Map.Entry;

public class RussianPeasantMultiplication {

	public int multiplyNumbers(int x, int y) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(x > y) {
			map.put(y, x);
			int t = y;
			y = x;
			x =t;
		}
			
		else 
			map.put(x, y);
		
		while(x!=1) {
			x = x/2;
			y=y+y;
			map.put(x, y);
		}
		
		int sum = 0;
		for(Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getKey()%2 != 0) {
				sum +=m.getValue();
			}
		}
		return sum;
	}
	
	
	public int findProduct(int x, int y) {
		if(x == 1)
			return y;
		if(x%2!=0)
			return y + findProduct(x/2,2*y);
		else 
			return findProduct(x/2, 2*y);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RussianPeasantMultiplication m = new RussianPeasantMultiplication();
		System.out.println(m.multiplyNumbers(846, 908));
		System.out.println(m.findProduct(846, 908));
	}

}
