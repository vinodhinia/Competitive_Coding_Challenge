import java.util.*;

public class IsPalindrome {

	public boolean isPalindromRec(String str, int left, int right, boolean oneDeletionDone) {
		if(left > right)
			return true;
		
		if(str.charAt(left) != str.charAt(right)) {
			if (!oneDeletionDone) {
				oneDeletionDone = true;
				return isPalindromRec(str, left, right-1, oneDeletionDone) || isPalindromRec(str, left+1, right, oneDeletionDone);
			}	
			else
			return false;
		};
		left++;
		right--;
		return isPalindromRec(str, left, right, oneDeletionDone);
			
	}
	
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		int min = Integer.MAX_VALUE;
		List<String> slist = new ArrayList<String>();
		String[] result = new String[1];
        for(int i=0;i<list1.length;i++) {
        	for(int j=0;j<list2.length;j++) {
        		if(list1[i].equals(list2[j]) && i+j < min) {
        			min = i+j;
        			result[0] = list2[j];
        		}
        	}
        }
        result = new String[slist.size()];
        
        int i=0;
        for(String s:slist)
        	
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPalindrome p = new IsPalindrome();
		String str = "madbcam";
		System.out.println(p.isPalindromRec(str, 0, str.length()-1, false));
		
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		String[] r = p.findRestaurant(list1, list2);
		System.out.println(r[0]);
	}

}
