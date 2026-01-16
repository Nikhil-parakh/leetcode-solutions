/* Leetcode 2442 => Count Number of Distinct Integers After Reverse Operations */
import java.util.HashSet;
public class code2442{
    public static void main(String args[]){
        int[] nums = {1,13,10,12,31};
        int count = countDistinctIntegers(nums);
        if(count == 6) System.out.println("True"); //note: static check for this particular array only.
        else System.out.println("False");
    }

    public static int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
            int rev = 0;
            while(nums[i] != 0){
                rev = rev*10 + nums[i]%10;
                nums[i] /= 10;  
            }
            set.add(rev);
        }
        return set.size();
    }
}