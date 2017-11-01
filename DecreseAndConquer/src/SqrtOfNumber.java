import java.text.DecimalFormat;

public class SqrtOfNumber {

	public double sqrtOfNumber(int num) {
		double res = 10;
		int i = 0;
		while(i++ <= 6) {
			double f1 = (res * res) - num;
			double f2 = (2 * res);
			res = (res) - (f1/f2);
			res =  Math.round(res*1000000.0)/1000000.0;
		}
		return res;
	}
	
	public float findSqrt(int num) {
		float low = 0,high = (float)num/2;
		while(low <= high) {
			float mid = (low + high)/2;
			float sqrt = mid * mid;
			if(sqrt == num)
				return mid;
			if(sqrt < num)
				low = (float) (mid + 0.000001);
			else 
				high = (float) (mid - 0.000001);
		}
		return low;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqrtOfNumber sqrt = new SqrtOfNumber();
		System.out.println(sqrt.sqrtOfNumber(9));
		System.out.println(sqrt.findSqrt(9));
	}

}
