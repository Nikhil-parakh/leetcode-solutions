/*
    problem statement: Given a binary tree, determine if it is height-balanced.
    *Need to check the given tree is balanced or not..
    what to you mean with balanced here? => in a tree the difference between (left tree height) and (right tree height) should be either 1 or 0. for everynode root -> every leaf node!
*/
import java.util.*;
class Node {
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

public class code110{

    public static void print(List<Integer> list){
        for(int ele : list){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static int helper(Node root, boolean[] ans){
        if(root == null) return 0;
        int leftHeight = helper(root.left, ans);
        int rightHeight = helper(root.right, ans);
        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1) ans[0] = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(Node root){
        boolean[] ans = {true};
        helper(root, ans);
        return ans[0];
    }


    public static void main(String args[]){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        c.right = e;
        c.left = d;

        System.out.println("result: " + isBalanced(a));
    }
}

/*
leetcode question number 110.

class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        if (left == -1) return -1;

        int right = height(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

}
*/