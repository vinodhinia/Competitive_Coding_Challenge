class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	
	public static boolean doesOverlap(Point l1, Point r1, Point l2, Point r2) {
		if(l2.x < r1.x )
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);
		
		System.out.println(doesOverlap(l1, r1,l2,r2));
		
	}

}
