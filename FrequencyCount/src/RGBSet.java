
public class RGBSet {
	
	public int rgbSet(String s) {
		s = s.toLowerCase();
		char[] ch = s.toCharArray();
		int rcount=0, gcount=0,bcount=0;
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i] == 'r')
				rcount++;
			else if(ch[i] == 'b')
				bcount++;
			else if(ch[i] == 'g')
				gcount++;
			
		}
		int min = Math.min(rcount, bcount);
		return Math.min(min, gcount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RGBSet rgb = new RGBSet();
		
		System.out.println(rgb.rgbSet("bbrr"));
	}

}
