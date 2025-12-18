/* Leetcode 543 => Diameter of Binary Tree
    find the longest path of the tree... to travel left to right of root!    
*/

import java.util.*;

class Node{
    Node left;
    Node right;
    int val;

    Node(int val){
        this.left = null;
        this.right = null;
        this.val = 0;
    }
}



public class code543{

    static int maxDia = 0;

    public static int diameter(Node root){

        if(root == null) return 0;

        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);

        int dia = leftHeight + rightHeight;
        maxDia = Math.max(maxDia, dia);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static void main(String args[]){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(10);
        Node k = new Node(11);
        Node l = new Node(12);
        Node m = new Node(13);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;
        f.right = j;
        g.left = k;
        k.left = l;
        k.right = m;

        // Node a = new Node(1);
        // Node b = new Node(2);
        // Node c = new Node(3);
        // Node d = new Node(4);
        // Node e = new Node(5);

        // a.left = b;
        // a.right = c;
        // c.left = d;
        // c.right = e;

        diameter(a);
        System.out.println("Diameter of tree: " + maxDia);
    }
}