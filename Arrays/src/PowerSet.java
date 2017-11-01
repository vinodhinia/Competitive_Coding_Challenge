import java.util.*;

public class PowerSet {
	
	public List<String> powerSet(String s){
        List<String> result = new ArrayList<String>();
        int p=0;
        result.add("");
        return powerSetHelper( s,  result,  p);
    }
    
    public List<String> powerSetHelper(String s, List<String> result, int p){
      if(p == s.length())
        return result;
      int size = result.size();
      for(int i=0;i<size;i++){
            String temp = result.get(i);
            temp = temp + s.charAt(p);
            result.add(temp);
        }  
    return powerSetHelper(s, result, p+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerSet p = new PowerSet();
		List<String> r = p.powerSet("abc");
		Iterator it = r.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

}
