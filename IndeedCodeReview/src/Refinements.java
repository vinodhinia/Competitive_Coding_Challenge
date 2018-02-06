import java.util.*;

public class Refinements {
	final int SIZE;
	
	Refinements(int size){
		this.SIZE  = size;
	}
	
	class Refinement{
		String label;
		int count;
		
		public String getLabel() {
			return label;
		}
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		public void createMap(List<HashMap<String, String>> listOfMaps) {
			
			for(HashMap<String, String> m : listOfMaps) {
				for(Map.Entry<String, String> entry:  m.entrySet()) {
					
				}
			}
		}
		
		public  HashMap<String, String> flattenDictHelper(String key,HashMap<String, String> result, HashMap<String, Object> dict ){
			
			for(Map.Entry<String, Object> m: dict.entrySet()) {
				if(m.getValue() instanceof Map) {
	        if(key == "" || key ==null){
	          flattenDictHelper(key,result,dict);
	        }else
					  flattenDictHelper(key+"."+m.getKey(),result, dict);
				}else {
					if(key == "" || key == null) {
						result.put(m.getKey(), (String) m.getValue());
					}else {
						result.put(key+"."+m.getKey(), (String)m.getValue());
					}
				}
			}
			return result;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Refinements r1 = new Refinements(20);
		Refinements r2 = new Refinements(30);
		
		//String input = "[{"id":1,"name":"San Francisco Bay Area","parent_id":null},{"id":2,"name":"San Jose","parent_id":3},{"id":3,"name":"South Bay","parent_id":1},{"id":4,"name":"San Francisco","parent_id":1},{"id":5,"name":"Manhattan","parent_id":6},{"id":6,"name":"New York","parent_id":null}]";
		
		List<HashMap<String, String>> listOfMaps = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", String.valueOf(1));
		map.put("name", "San Francisco Bay Area");
		map.put("parent_id", null);
		
		listOfMaps.add(map);        		                 
		map = new HashMap<String, String>();
		map.put("id", String.valueOf(2));
		map.put("name", "San Jose");
		map.put("parent_id", String.valueOf(3));
		listOfMaps.add(map);        	
	}

}
