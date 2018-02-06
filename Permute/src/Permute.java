
public class Permute {
	int MAX_DIGITS = 10;
//	https://repl.it/repls/FrostyStylishChihuahua
	//https://github.com/shamirwa/HandsOn/blob/master/SimilarNumber.cpp
	public int solution(int n) {
		String num;
		StringBuilder buff = new StringBuilder(Integer.toString(n));
		num = buff.toString();
		
		char[] charMap = new char[MAX_DIGITS];
		int numLen = num.length();
	    for(int i=0; i<numLen; ++i)
	    {
	        charMap[num.charAt(i) - '0']++;
	    }
	    int count = countHelper(numLen, charMap);
	    if (charMap[0] != 0) {
	        charMap[0]--;
	        count = count - countHelper(numLen - 1, charMap);
	    }
	    return count;
	}
	
	public int countHelper(int length, char[] charMap) {
	    long numerator = factorial(length);
	    long denominator = 1;
	    int numLen = MAX_DIGITS;

	    for(int i=0; i<numLen; ++i)
	    {
	        if(charMap[i] > 1)
	        {
	            denominator *= factorial(charMap[i]);
	        }
	    }

	    long count = numerator / denominator;
	    return (int) count;
	}
	
	public long factorial(int n) {
	    long result = 1;
	    for (int i = 2; i <= n; ++i) {
	        result *= i;
	    }
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permute p = new Permute();
		System.out.println(p.solution(1213));
	}

}
