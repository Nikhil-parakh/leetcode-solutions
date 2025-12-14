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

public class code144{

    public static void print(List<Integer> list){
        for(int ele : list){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void preOrder(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null)    return;
        stack.push(root);

        while(!stack.empty()){
            Node temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }

        print(list);
    }

    public static void main(String args[]){
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

        preOrder(a);
    }
}

/*
Leet code question no. 144
pre order traversal in tree using stack.

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            tree.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return tree;
    }
}
*/