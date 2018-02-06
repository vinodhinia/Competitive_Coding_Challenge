import java.util.*;

public class MyQueue implements Queue{
	TreeMap<Integer, T> map = new TreeMap<Integer, T>();
	int it;
	
	MyQueue(){
		it = 0;
	}

	@Override
	public void Enqueue(Object t) {
		// TODO Auto-generated method stub
		map.put(it++, (T) t);
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(map.size() == 0)
			return null;
		
		if(it == map.size()) {
			T tobj = map.get(0);
			map.remove(0);
			return tobj;
		}
		int lastIndex = it -1;
		int size = map.size();
		int key = Math.abs(size - lastIndex) + 1;
		T tobj = map.get(key);
		map.remove(key);
		return tobj;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyQueue q = new MyQueue();
//		T t = new T(0);
//		q.Enqueue(t);
//		System.out.println(q.dequeue().data);
//		t = new T(1);
//		q.Enqueue(t);
//		t = new T(2);
//		q.Enqueue(t);
//		t = new T(3);
//		q.Enqueue(t);
//		System.out.println(q.dequeue().data);
//		System.out.println(q.dequeue().data);
//		System.out.println(q.dequeue().data);
		
		String a = "a";
		char c = 'c';
		System.out.println((c - 'A'));
		
	}


}
