import java.util.*;

import Node;
public class code199{

    public static int level(Node root){
        if(root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    public void print(List<Integer> list){
        for(int ele : list){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public void helper(Node root, int level, List<Integer> ans){
        if(root == null) return;
        helper(root.left, level+1, ans);
        helper(root.right, level+1, ans);
        ans.set(level, root.val);
    }

    public static void main(String args[]){
        
        code199 obj = new code199();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.right = g;

        int length = level(a);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < length; i++){
            ans.add(0);
        }
        obj.helper(a, 0, ans);
        obj.print(ans);
    }
}

/*
Leet code question no. 199

class Solution {
    public int level(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }
    public void postorder(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;
        postorder(root.left, level+1, ans);
        postorder(root.right, level+1, ans);
        ans.set(level,root.val);
    }
    public List<Integer> rightSideView(TreeNode root) {
        int length = level(root);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < length; i++){
            ans.add(0);
        }
        postorder(root, 0, ans);
        return ans;
    }
}
*/
