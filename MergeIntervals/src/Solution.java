import java.util.*;

class Interval{
	int start;
	int end;
	Interval(){
		start = 0;
		end = 0;
	}
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class Solution {
	
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		Stack<Interval> stack = new Stack<Interval>();
		boolean isNewIntervalMerged = false;
		
		if(intervals.size() > 1)
			stack.push(intervals.get(0));
		
		for(int i=1;i<intervals.size();i++) {
			Interval t = intervals.get(i);
		
			if(!isNewIntervalMerged && newInterval.start < stack.peek().end && newInterval.end >= stack.peek().start) {
				if(stack.peek().end < newInterval.end) {
					stack.peek().end = newInterval.end;
				}
				if(stack.peek().start > newInterval.start)
					stack.peek().start = newInterval.start;
				isNewIntervalMerged = true;
			}
			if(t.start < stack.peek().end) {
				if(stack.peek().end < t.end) {
					stack.peek().end = t.end;
				}
				if(stack.peek().start > t.start)
					stack.peek().start = t.start;
			}else
				stack.push(t);
		}
		
		if(!isNewIntervalMerged) {
			if(!isNewIntervalMerged && newInterval.start < stack.peek().end && newInterval.end >= stack.peek().start) {
				if(stack.peek().end < newInterval.end) {
					stack.peek().end = newInterval.end;
				}
				if(stack.peek().start > newInterval.start)
					stack.peek().start = newInterval.start;
				isNewIntervalMerged = true;
			}else
				result.add(newInterval);
		}
		
		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
		
		
		Collections.sort(result, new Comparator<Interval>() {
			
			public int compare(Interval i1, Interval i2) {
				if( i1.start <= i2.start)
					return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
			}

			
		});
		
		
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2141136, 6363582));
		intervals.add(new Interval(49844342, 69670172));
		intervals.add(new Interval(75717793, 86352601));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(12, 16));
		
		ArrayList<Interval> res =  s.insert(intervals, new Interval(72706854, 87016111));
		for(Interval in : res) {
			System.out.println(in.start + " " + in.end);
		}
	}

}
