
public class LongestUnCommonSub {
	
	public int findLUSlength(String a, String b) {
        if(a==b)
        	return -1;
        return Math.max(a.length(), b.length());
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
