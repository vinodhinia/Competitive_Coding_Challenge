
public class SortDigits {
	
	public int sortDigits(String s) {
		String result = "";
		StringBuffer buff = new StringBuffer();
		int[] digits = new int[10];
		
		char[] charr = s.toCharArray();
		for(int i=0;i<charr.length;i++) {
			//System.out.println(charr[i]-'0');
			digits[charr[i] - '0']++;
		}
		for(int i=1;i<digits.length;i++) {
			if(digits[i] > 0 ) {
				int count = digits[i];
				while(count!=0) {
					buff.append(i);
					count--;
				}
			}
		}
		return Integer.valueOf(buff.toString());
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortDigits s = new SortDigits();
		System.out.println(s.sortDigits("8970"));
	}

}
