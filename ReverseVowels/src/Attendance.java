import java.util.*;
public class Attendance {
	
	public boolean checkRecord(String s) {
		char charA = 'A';
		char charL = 'L';
		int countA =0,conitiousL = 0;
		for(int i=0;i<s.length();i++) {
			char t = s.charAt(i);
			if(t == charA) {
				countA++;
			}else if(charL == t) {
				if(i+2<s.length() && s.charAt(i+1)==charL && s.charAt(i+2)==charL) {
					conitiousL = 3;
					i = i+2;
					return false;
				}else {
					conitiousL = 0;
				}
				
			}
		}
		if(countA>=2 || conitiousL>=2) {
			return false;
		}
		return true;
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
//		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        if(ransomNote.length() > magazine.length())
            return false;
        else if(ransomNote.length() == magazine.length())
            return ransomNote.equals(magazine);
            
        StringBuffer buff = new StringBuffer(magazine);
        for(int i=0;i<ransomNote.length();i++) {
        	char ch = ransomNote.charAt(i);
        	if(magazine.indexOf(ch)!=-1) {
        		magazine = magazine.substring(0,magazine.indexOf(ch)) + magazine.substring(magazine.indexOf(ch)+1);
        	}else {
        		return false;
        	}
        		
        }
        return true;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Attendance a = new Attendance();
		//System.out.println(a.checkRecord("PPALLP"));
		String s = ", , , ,        a, eaefa";
		s.trim();
		String[] sarr = s.split(" ");
		System.out.println(sarr.length);
		
		//System.out.println(a.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
	}

}
