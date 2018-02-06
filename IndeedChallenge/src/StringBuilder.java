import java.util.*;

public class StringBuilder {
    
	private static class Node {
        String substring;
        int startIndex;
    }

    private List<Node> nodes = new ArrayList<Node>();

    public void append(String s) {
        Node n = new Node();
        n.substring = s;
        if (nodes.size() > 0) {
            Node tail = nodes.get(nodes.size() - 1);
            n.startIndex = tail.startIndex + tail.substring.length();
        } else {
            n.startIndex = 0;
        }
        nodes.add(n);
    }
    
    // Indeed dot 
    // 012345 6
    public char charAt(int index) {
        //implement this
        // Traverse all the nodes in the list
        // look at startIndex if startIndex < index && nextNode.startIndex> index 
        
        if(nodes.size() < 1)
            return ' ';
            
        Node tail = nodes.get(nodes.size() - 1);
        int possibleIndex = tail.startIndex + tail.substring.length() -1;
        
        if( index < 0 || index > possibleIndex)
            return ' ';
            
        for(Node n : nodes){
            if(n.startIndex <= index && n.startIndex+n.substring.length() > index){
                String s = n.substring;
                int i = index - n.startIndex;
                return s.charAt(i);
            }
        }
        
        return ' ';
    }
    
    
//    "abc" -> "def" -> "ghi"
//    012      345      678
//    0        3        6
//    0        1       2
    public char charAtV1(int index){
        if(nodes.size() < 1)
            return ' ';
            
        Node tail = nodes.get(nodes.size() - 1);
        int possibleIndex = tail.startIndex + tail.substring.length() -1;
        
        if( index < 0 || index > possibleIndex)
            return ' ';
            
        int start = 0, end = nodes.size()-1;
        
        while(start <= end){
            int mid = (start + end)/2;
            Node n = nodes.get(mid);
            // check if char is in the current Node
            if(n.startIndex <= index && n.startIndex+n.substring.length() > index){
                String s = n.substring;
                int i = index - n.startIndex;
                return s.charAt(i);
            }
            else if(n.startIndex > index){
                end = mid - 1;
            }else if(n.startIndex < index){
                start = mid + 1;
            }
        }
        return ' ';
    }
    
    public static void main(String[] args) {
    		StringBuilder sb = new StringBuilder();
    		sb.append("abc");
    		sb.append("def");
    		sb.append("ghi");
    		
    		System.out.println(sb.charAtV1(2));
    		
    }
}

//sb         n 
//
//sb.charAt(2) -> 'c'
//sb.charAt(3) -> 'd'
