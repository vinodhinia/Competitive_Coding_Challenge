import java.util.*;

public class Solution {
	
	public String getShortestUniqueSubstring(String str, char[] ch) {
		int headIndex = 0;
		String result = "";
		int uniqueCounter = 0;
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<ch.length; i++) {
			countMap.put(ch[i], 0);
		}
		
//arr = ['x','y','z'], str = "xyyzyzyx"
		for(int tailIndex = 0; tailIndex < str.length()-1; tailIndex++) {
			char tailChar = str.charAt(tailIndex);
			if (!countMap.containsKey(tailChar))
	            continue;
			
			int tailCount = countMap.get(tailChar);
			if (tailCount == 0)
	            uniqueCounter = uniqueCounter + 1;
			
			countMap.put(tailChar, tailCount + 1);
			
			while (uniqueCounter == ch.length) {
				int tempLength = tailIndex - headIndex + 1;
				if (tempLength == ch.length) {
					return str.substring(headIndex, tailIndex);
				}
				if (result == "" || tempLength < result.length()) {
					result = str.substring(headIndex, tailIndex);
				}
				char headChar = str.charAt(headIndex);
				if (countMap.containsKey(headChar)) {
	                int headCount = countMap.get(headChar) - 1;
	                if(headCount == 0)
	                    uniqueCounter = uniqueCounter - 1;
	                countMap.put(headChar, headCount);
				}
	            headIndex = headIndex + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'x','y','z'};
		String str = "xyyzyzyx";
	}

}
