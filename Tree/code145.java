import java.util.*;

public class code145{

    public static void print(List<Integer> list){
        for(int ele : list){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void postOrder(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null)    return;
        stack.push(root);

        while(!stack.empty()){
            Node temp = stack.pop();
            list.add(temp.val);
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        Collections.reverse(list);
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

        postOrder(a);
    }
}

/*
Leet code question no. 144
pre order traversal in tree using stack.

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            tree.add(temp.val);
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        Collections.reverse(tree);
        return tree;
    }
}
*/