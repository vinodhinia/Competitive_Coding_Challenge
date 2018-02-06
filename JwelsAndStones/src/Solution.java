
public class Solution {
	
	public static int numJewelsInStones(String J, String S) {
        if(J == null)
            return 0;
        if(S == null)
            return 0;
        int count = 0;
        for(int i=0;i<J.length();i++){
            while(S.indexOf(J.charAt(i)) != -1){
                count++;
                int index = S.indexOf(J.charAt(i));
                S = S.substring(0, index) + S.substring(index+1, S.length());
            }
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J= "z", S = "ZZ";
		System.out.println(numJewelsInStones(J, S));
	}

}
