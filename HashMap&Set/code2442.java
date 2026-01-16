/* Leetcode 2442 => Count Number of Distinct Integers After Reverse Operations */
import java.util.HashSet;
public class code2442{
    public static void main(String args[]){
        String[] words = {"cd","ac","dc","ca","zz"};
        int count = maximumNumberOfStringPairs(words);
        if(count == 2) System.out.println("True"); //note: static check for this particular array only.
        else System.out.println("False");
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i < words.length;i++){
            StringBuilder rev = new StringBuilder(words[i]);
            String a = rev.reverse().toString();
            if(set.contains(a)){
                count++;
                set.remove(words[i]);
            } else {
                set.add(words[i]);
            }
        }
        return count;
    }
}