/* Leetcode 105 => Construct Binary tree with given inorder and preorder!
   
*/

import java.util.*;

class Node{
    Node left;
    Node right;
    int val;

    Node(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }
}



public class code105{

        public static Node helper(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh){
            //base case..
            if(preLow > preHigh || inLow > inHigh) return null;

            //Node to be returned
            Node root = new Node(preorder[preLow]);

            int r = 0; 
            while(inorder[r] != preorder[preLow]) r++;
            int size = r - inLow;

            root.left = helper(preorder, inorder, preLow+1, preLow+size, inLow, r-1);
            root.right = helper(preorder, inorder, preLow+size+1, preHigh, r+1, inHigh);

            return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, inorder, 0, n-1, 0, n-1);
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String args[]){
        int preOrder[] = {3, 9, 20, 15, 7}; 
        int inOrder[] = {9, 3, 15, 20, 7}; 

        Node root = buildTree(preOrder, inOrder);

        //printing constructed tree
        System.out.print("Preorder:- ");
        preorder(root);
        System.out.println();
        
        System.out.print("Inorder:- ");
        inorder(root);
        System.out.println();

    }
}