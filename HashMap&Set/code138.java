/* Leetcode-138 Copy List with Random Pointer
    Solved with two different approches.
    first = Hashmap tc = O(n) & SC = O(n)
    second(Commented*) = LionkedList tc = O(n) & SC = O(1)
*/

import java.util.*;
public class code138{
    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String args[]){
        code138 obj = new code138();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.next = b;
        a.random = c;

        b.next = c;

        c.next = d;
        c.random = e;

        d.next = e;
        d.random = a;

        e.next = f;
        e.random = b;

        f.random = c;

        // Node temp = a;
        // while(temp != null){
        //     System.out.println("node val = "+temp.val);
        //     if(temp.next != null)
        //         System.out.println("node next = "+temp.next.val);
        //     if(temp.random != null)
        //         System.out.println("node random = "+temp.random.val);
        //     temp = temp.next;
        // }

    Node head2 = obj = copyRandomList(a); //Node head2 is the final deep copy generated.
    }
    public Node deepCopy(Node head){
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while(t1 != null){
            Node temp = new Node(t1.val);
            t2.next = temp;
            t1 = t1.next;
            t2 = t2.next;
        }
        return head2;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node head2 = deepCopy(head);
        HashMap<Node, Node> map = new HashMap<>();
        Node t1 = head;
        Node t2 = head2;
        while(t1 != null || t2 != null) {
            map.put(t1, t2);
            t1 = t1.next;
            t2 = t2.next;
        }

        t1 = head;
        t2 = head2;

        while(t1 != null || t2 != null) {
            t2.random = map.get(t1.random);
            t1 = t1.next;
            t2 = t2.next;
        }
        return head2;
    }
}

//Second Approach 
/*
class Solution {
    public Node deepCopy(Node head){
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while(t1 != null){
            Node a = new Node(t1.val);
            t2.next = a;
            t1 = t1.next;
            t2 = t2.next;
        }
        return head2;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return head;
    
        //step 1 = creation of deep copy!
        Node head2 = deepCopy(head);

        //step 2 = connecting original list with new list = [7,13,11]->[7*,13*,11*] = [7,7*,13,13*,11,11*]!
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t1 = head, t2 = head2;
        while(t1 != null || t2 != null){
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }

        //step 3 = assigning randam pointers to new head!
        t1 = head;
        t2 = head2;
        while(t1 != null){
            if(t1.random != null) t2.random = t1.random.next;
            else t2.random = null;
            t1 = t1.next.next;
            if(t2.next == null) {
                t2 = t2.next;
                break;
            }
            t2 = t2.next.next;
        }

        //step 4 breaking down the connection of both lists with each other!
        t1 = head;
        t2 = head2;
        while(t1 != null || t2 != null){
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 == null){
                t2.next = null;
                break;
            }
            t2.next = t1.next;
            t2 = t2.next;
        }

        return head2;

    }
}
*/