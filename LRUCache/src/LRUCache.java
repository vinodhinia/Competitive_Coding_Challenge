import java.util.*;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}


public class LRUCache {
    
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public void remove(Node n){
        
        // Consider head case
        if(n.prev != null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }
        
        
        //consider tail case
        if(n.next != null){
            n.next.prev = n.prev;
        }else{
            end = end.prev;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.prev = null;
        if(head != null){
            head.prev = n;
        }
        head = n;
        if(end==null){
            end = head;
        }
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node created = new Node(key, value);
        if(map.containsKey(key)) {
        		Node n = map.get(key);
        		n.value = value;
        		remove(n);
        		setHead(n);
        }else {
	        	if(map.size() >= this.capacity){
	                map.remove(end.key);
	                remove(end);
	            }
	            setHead(created);
	            map.put(key, created);
        }
        
    }
    
    
    public static void main(String[] args) {
    		LRUCache lrucache = new LRUCache(2);
    		System.out.println(lrucache.get(2));
    		lrucache.put(2,6);
    		
    		System.out.println(lrucache.get(1));
    		lrucache.put(1,5);
    		lrucache.put(1,2);
    		System.out.println(lrucache.get(1));
    		System.out.println(lrucache.get(2));
    	
    }
}