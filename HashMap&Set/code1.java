import java.util.*;
public class code1{
    public static void main(String args[]){
        code1 obj = new code1();
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = {-1,-1};
        for(int i = 0;i < nums.length;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                result[0] = map.get(rem);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}