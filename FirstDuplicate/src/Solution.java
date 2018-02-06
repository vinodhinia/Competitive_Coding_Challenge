// you can import things up here if you want
import java.util.*;
public class Solution {
    public static int ascii_deletion_distance(String str1, String str2) {
        int sum = 0;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
       
        for(int i=0;i<str1.length();i++){
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0;i<str2.length();i++){
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i),0)+1);
        }
        for(Map.Entry<Character, Integer> m : map1.entrySet()){
            if(map2.containsKey(m.getKey())){
                int diff = Math.abs(m.getValue() - map2.get(m.getKey()));
                sum += diff * (int) m.getKey();
            }
               if(!map2.containsKey(m.getKey())){
                   sum += (int)m.getKey();
               }
        }
                  
        for(Map.Entry<Character, Integer> m : map2.entrySet()){
            if(!map1.containsKey(m.getKey())){
                   sum += (int)m.getKey();
            }
        }
       return sum;
    }
}
