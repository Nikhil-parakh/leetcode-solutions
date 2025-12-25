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



public class code106{

        public static Node helper(int[] inorder, int[] postorder, int postLow, int postHigh, int inLow, int inHigh){
        if(postLow > postHigh || inLow > inHigh) return null;

        Node root = new Node(postorder[postHigh]);

        int rootIndex = inLow;
        while(inorder[rootIndex] != postorder[postHigh]) rootIndex++;
        int size = rootIndex - inLow;

        root.left = helper(inorder, postorder, postLow, postLow + size-1, inLow, rootIndex - 1);
        root.right = helper(inorder, postorder, postLow + size, postHigh - 1, rootIndex + 1, inHigh);
        return root;
    }
    
    public static Node buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }

    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String args[]){
        int postOrder[] = {9, 15, 7, 20, 3}; 
        int inOrder[] = {9, 3, 15, 20, 7}; 

        Node root = buildTree(inOrder, postOrder);

        //printing constructed tree
        System.out.print("Postorder:- ");
        postorder(root);
        System.out.println();
        
        System.out.print("Inorder:- ");
        inorder(root);
        System.out.println();

    }
}