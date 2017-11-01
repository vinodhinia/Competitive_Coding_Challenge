import java.util.*;

public class MinStack {
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
	    
	 public static void main(String[] args) {
		 int[] a = {-2,0,-3};
		 MinStack m = new MinStack();
		 for(int i=0;i<a.length;i++) {
			 m.push(a[i]);
		 }
		 System.out.println("Stack after Insertion ");
//		 m.printStack();
		 System.out.println("Get Min in Stack");
		 System.out.println(m.getMin());
		 System.out.println("Pop");
		 m.pop();
		 System.out.println(m.getMin());
//		 m.printStack();
		 System.out.println("Get Min in Stack");
		 System.out.println(m.getMin());
		 
	 }
}
