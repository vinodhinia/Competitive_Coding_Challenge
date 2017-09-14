import java.util.*;
public class MyQueue {
	
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        int first = s2.pop();
        while(!s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return first;
    }
    
    /** Get the front element. */
    public int peek() {
    	while(!s1.isEmpty()) {
        	s2.push(s1.pop());
        }
        int first = s2.peek();
        while(!s2.isEmpty()) {
        	s1.push(s2.pop());
        }
        return first;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty())
        	return true;
        return false;
    }
    
    public void printQ() {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
    	while(!s2.isEmpty()) {
    		System.out.print(s2.peek() + " ");
    		s1.push(s2.pop());
    	}
    	System.out.println("\n");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue q = new MyQueue();
		int[] a = {1,2,3,4,5,6};
		for(int i=0;i<a.length;i++)
			q.push(a[i]);
		System.out.println("Queue: ");
		q.printQ();
		System.out.println(q.pop());
		System.out.println("Queue after pop");
		q.printQ();
	}

}
