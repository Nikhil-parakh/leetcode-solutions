/* Leetcode 242. Valid Anagram -> 3 approaches explained.*/
import java.util.*;
public class code242{
    public static void main(String args[]){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t)); //true
    }

    // solution 1. //TC O(n log n) & SC:O(k) best for fresher/understanding.
    public static boolean isAnagram(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        s = String.valueOf(arr1);
        t = String.valueOf(arr2);

        if(s.equals(t)){
            return true;
        } else return false;
    }

    //solution 2. in this approach TC:O(n)& SC:O(k) best when string has uppercase/symbols etc.
    // public static boolean isAnagram(String s, String t) {
    //     if(s.length() != t.length()) return false;

    //     HashMap<Character, Integer> smap = new HashMap<>();
    //     for(int i = 0;i < s.length();i++){
    //         char key = s.charAt(i);
    //         if(smap.containsKey(key)){
    //             int freq = smap.get(key);
    //             smap.put(key,freq+1);
    //         } else {
    //             smap.put(key,1);
    //         }
    //     }

    //     HashMap<Character, Integer> tmap = new HashMap<>();
    //     for(int i = 0;i < t.length();i++){
    //         char key = t.charAt(i);
    //         if(tmap.containsKey(key)){
    //             int freq = tmap.get(key);
    //             tmap.put(key,freq+1);
    //         } else {
    //             tmap.put(key,1);
    //         }
    //     }

    //     for(char key : smap.keySet()){
    //         if(!tmap.containsKey(key)) return false;
    //         int val1 = smap.get(key); 
    //         int val2 = tmap.get(key); 
    //         if(val1 != val2) return false;
    //     }
    //     return true;
    // }

    // // solution 3. this approch is best for lowercase elements only.
    // public static boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) return false;

    //     int[] freq = new int[26];

    //     for (int i = 0; i < s.length(); i++) {
    //         freq[s.charAt(i) - 'a']++;
    //         freq[t.charAt(i) - 'a']--;
    //     }

    //     for (int count : freq) {
    //         if (count != 0) return false;
    //     }
    //     return true;
    // }
}