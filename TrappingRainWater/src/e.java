
public enum e {

}



//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//// Time complexity for all methods are to be in O(1)
//interface FastElementStore<Element> {
//  
//  void add(Element e); 
//  
//  boolean remove(Element e);
//  
//  Element removeRandom(); // Code this later
//  
//}

// HashSet: https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
// ArrayList.remove(index) time complexity O(n) - why?
// ArrayList.get(index) time complexity O(1)
//
//[1 2 3 4 5 6 7]
//[1 2 3 5 6 7] // how can we use ArrayList to do O(1) remove without needing to guarantee order?
//
//[1 2 3 4 5 6 7]
//[1 2 3 7 5 6 4] // swapping elements O(1)
//
//it=0
// HashMap<Element, Integer> - O(1)
// ArrayList<Element> - O(1)
  
// ArrayList.add(element) O(1)
// ArrayList.remove(element) O(n)
  
//
//  class ElementStore implements FastElementStore<Element>{
//    
//    HashMap<Element, Integer> map = new HashMap<Element, Integer>();
//    ArrayList<Element> list = new ArrayList<Element>();
//    
//  
//  @Override
//  void add(Element e){
//    
//  }
//  
//  @Override
//  boolean remove(Element e)
//    
//    
//  @Override
//  Element removeRandom(){
//    Random rand = new Random();
//    int n = rand.next(list.size()-1);
//    
//    Element e = list.get(n);
//    map.remove(e);
//    
//    Element lastElement  = list.get(list.size()-1);
//    Element temp = lastElement;
//    list.set(n, lastElement);
//    list.set(list.size()-1, e);
//    
//    
//    list.remove(e);
//    
//    
//    
//  }
//    
//  }