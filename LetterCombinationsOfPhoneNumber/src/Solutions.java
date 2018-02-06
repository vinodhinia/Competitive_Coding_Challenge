import java.util.*;

public class Solutions {
	
	public List<String> letterCombinations(String digits){
		List<String> res = new ArrayList<String>();
		String[] letters = { "0", "1" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		
		for(int i=0;i<digits.length();i++) {
			int ch = digits.charAt(i) - '0';
			String s = letters[ch];
			
			List<String> temp = new ArrayList<String>();
			for(int j=0;j<s.length();j++) {
				for(int k=0;k<res.size();k++) {
					temp.add(res.get(k)+s.charAt(j));
				}
			}
			res = temp;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutions s = new Solutions();
		s.letterCombinations("23");
	}

}
