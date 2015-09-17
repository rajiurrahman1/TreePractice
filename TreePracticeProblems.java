package TreePractice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Rajiur
 */
class ListNode{
    int data;
    ListNode next;
}


public class TreePracticeProblems {
    private static Node buildTree(){
        Node root = new Node();
        Node n9 = new Node();
        Node n6 = new Node();
        Node n12 = new Node();
        Node n10 = new Node();
        Node n13 = new Node();
        Node n19 = new Node();
        Node n25 = new Node();
        root.setData(17);
        n9.setData(9);
        n6.setData(6);
        n12.setData(12);
        n10.setData(10);
        n13.setData(13);
        n19.setData(19);
        n25.setData(25);
        
        root.left = n9;
        root.right = n19;
        n9.left = n6;
        n9.right = n12;
        n12.left = n10;
        n12.right = n13;
        n19.right = n25;
        
        
        return root;
    }
    public static int getTreeHeight(Node root){
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = getTreeHeight(root.left);
        }
        if(root.right != null){
            rightHeight = getTreeHeight(root.right);
        }
        if(leftHeight > rightHeight){return leftHeight+1;}
        else{return rightHeight+1;}
    }
    public static void topView(Node root){
        if(root != null){
            if(root.left != null || root.right != null){
                topView(root.left);
                System.out.print(root.getData() + " ");
                topView(root.right);
            }    
        }
    }    
    public static ListNode buildSortedLinkedList(){
        ListNode head = new ListNode();
        head.data = 1; 
        ListNode node2 = new ListNode();
        node2.data = 2;
        head.next = node2;
        ListNode node3 = new ListNode();
        node3.data = 3;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.data = 4;
        node3.next = node4;
        ListNode node5 = new ListNode();
        node5.data = 5;
        node4.next = node5;
        ListNode node6 = new ListNode();
        node6.data = 6;
        node5.next = node6;
        ListNode node7 = new ListNode();
        node7.data = 7;
        node6.next = node7;
        node7.next = null;
        
        return head;
    }
    public static void printList(ListNode head) {
        if(head != null){
            while(head.next != null){
                System.out.println(head.data);
                head = head.next;
            }
            System.out.println(head.data);
        }

    }
    public static int countNodes(ListNode head)    {
        int count = 0;
        while(head!=null)
        {
          count++;
          head=head.next;
        }
        return count;  
    }
    public static Node sortedListToBST(ListNode head, int start, int end){
        if(start > end){return null;}
        int mid = start+(end-start)/2;
        int i=0;
        ListNode current = head;
        while(i<mid && current != null){
            current = current.next;
            i++;
        }
        Node root = new Node();
        root.setData(current.data);
        root.left = sortedListToBST(head, start, mid-1);
        root.right = sortedListToBST(head, mid+1, end);
        
        return root;
    }
    public static void tree_mirror(Node root){
        if(root == null){return;}
        else{
            Node temp = new Node();
            tree_mirror(root.left);
            tree_mirror(root.right);
            
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
    public static boolean printAncestors(Node root, int x){
        if(root == null){
            return false;
        }
        if(root.getData() == x){
            return true;
        }
        if( printAncestors(root.left, x) || printAncestors(root.right, x)  ){
            System.out.print(root.getData() + " ");
            return true;
        }
        return false;
    }
    public static int countNodes(Node root){//function overloading 
        if(root == null){
            return 0;
        }
        else{
            return 1+(countNodes(root.left)+countNodes(root.right));
        }
    }
    
    public static void main(String[] args){
        Node root = buildTree();
        ListNode head = buildSortedLinkedList();
//        printList(head);
        System.out.println(countNodes(head));
        Node root1 = sortedListToBST(head, 0, countNodes(head)-1);
        TreeTraversal.inOrderTraversal(root1);System.out.println();        
        tree_mirror(root1);
        TreeTraversal.inOrderTraversal(root1);System.out.println();
        boolean x = printAncestors(root, 6);
        System.out.println("\nTotal nodes in the tree: " + countNodes(root));
    }
}
