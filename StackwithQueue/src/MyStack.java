import java.util.*;

public class MyStack {
	Queue<Integer> q;
	
	public MyStack() {
        q = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++) {
        	q.add(q.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q.isEmpty())
        	return true;
        return false;
    }
    
    public void printStack() {
    	for(int i=0;i<q.size();i++) {
    		System.out.print(q.peek()+" ");
    		q.add(q.poll());
    	}
    	System.out.println("\n");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s = new MyStack();
		int[] a = {1,2,3,4,5};
		for(int i=0;i<a.length;i++) {
			s.push(a[i]);
		}
		System.out.println("Stack After Insertion");
		s.printStack();
		System.out.println("Delete top from stack");
		s.pop();
		s.printStack();
		System.out.println("Inserting to Stack");
		s.push(6);
		s.printStack();
		System.out.println("Delete top from stack");
		s.pop();
		s.printStack();
	}

}
