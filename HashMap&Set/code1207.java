/*leetcode - 1207. Unique Number of Occurrences */
import java.util.*;
public class code1207{
    public static void main(String args[]){
        code1207 obj = new code1207();
        int arr[] = {1,2,2,1,1,3}; //true for particular case.
        /* Explanation: The value 1 has 3 occurrences,
        2 has 2 and 3 has 1. No two values have the same number of occurrences. */
        System.out.println(obj.uniqueOccurrences(arr));
    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : arr){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        // System.out.println(map);
        Set<Integer> set = new HashSet<>();
        for(int value : map.values()){
            if(!set.add(value)) return false;
        }
        return true;
    }
}