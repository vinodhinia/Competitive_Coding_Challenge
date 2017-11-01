import java.util.*;

public class RouteCircle {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public void constructMap(String moves) {
		for(int i=0;i<moves.length();i++) {
			char ch = moves.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch,1);
			}
		}
	}
	
	public boolean judgeCircle(String moves) {
		constructMap(moves);
		return map.get('L')==map.get('R') && map.get('U')==map.get('D');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RouteCircle r = new RouteCircle();
		System.out.println(r.judgeCircle("LL"));
		
	}	

}
