/*Leetcode-2094 Finding 3-Digits Even Numbers */
import java.util.*;
public class code2094{
    public static void main(String args[]){
        code2094 obj = new code2094();
        int arr[] = {2, 2, 8, 8, 2};
        int result[] = obj.findEvenNumbers(arr);
        for(int i : result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int key : digits){
            if(map.containsKey(key)){
                int freq = map.get(key);
                map.put(key, freq+1);
            } else {
                map.put(key, 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 100; i<=999; i+=2){
            int x = i;
            int c = x%10; x /= 10;
            int b = x%10; x /= 10;
            int a = x;
            if(map.containsKey(a)){
                int afreq = map.get(a);
                map.put(a,afreq-1);
                if(afreq == 1) map.remove(a);
                if(map.containsKey(b)){
                int bfreq = map.get(b);
                map.put(b,bfreq-1);
                if(bfreq == 1) map.remove(b);
                if(map.containsKey(c)){
                    ans.add(i);
                }
                map.put(b,bfreq);
            }
                map.put(a,afreq);
            }
        }
        int[] ans2 = new int[ans.size()];
        for(int i = 0;i < ans2.length;i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}