import java.util.*;
public class code1814{
    public static void main(String args[]){
        int[] nums = {13,10,35,24,76}; 
        code1814 obj = new code1814();
        System.out.println(obj.countNicePairs(nums));
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n;i++){
            int ele = nums[i] - rev(nums[i]);
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                count += freq;
                count %= 1000000000 + 7;
                map.put(ele, freq+1);
            } else {
                map.put(ele, 1);
            }
        }
        return count;
    }
    public int rev(int n){
        int reverse = 0;
        while(n!=0){
            reverse = reverse*10 + n%10;
            n /= 10;
        }
        return reverse;

    }
}