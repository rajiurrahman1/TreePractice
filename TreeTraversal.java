package TreePractice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    private int data;
    public Node left;
    public Node right;
    public int getData(){
        return this.data;
    }
    public void setData(int x){
        this.data = x;
    }
}
   
public class TreeTraversal {
      
    public static void preOrderTraversal(Node root){
        if(root != null){
            System.out.print(root.getData() + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);        
        }
    }
    public static void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.right);        
        }
    }
    public static void postOrderTraversal(Node root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);  
            System.out.print(root.getData() + " ");            
        }
    }
    public static void LevelOrderTraversal(Node root){
        //simple BFS breadth first search traversal, 
        //no biggy, just use the Queue properly
        Queue<Node> treeQueue = new LinkedList<Node>();
        if(root != null){
            treeQueue.add(root);
            Iterator iter = treeQueue.iterator();
            while(!treeQueue.isEmpty()){
                Node currentNode = treeQueue.poll();
                System.out.print(currentNode.getData() + " ");
                if(currentNode.left != null){
                    treeQueue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    treeQueue.add(currentNode.right);
                }
            }
        }  
    }
    public static void spiralTraversal(Node root){
        //traverse the nodes in a zig-zag manner
        //first depth = 0, the root is printed 
        //then, depth = 1, nodes are printed from left to right
        //then, depth = 2, nodes are printed from right to left
        //then, depth = 3, nodes are printed from left to right .. and so on ..
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty() ){
            while(!stack1.isEmpty()){
                Node temp = stack1.pop();
                System.out.print(temp.getData() + " ");
                if(temp.left != null){stack2.push(temp.left);}
                if(temp.right != null){stack2.push(temp.right);}
            }
            while(!stack2.isEmpty()){
                Node temp = stack2.pop();
                System.out.print(temp.getData() + " ");
                if(temp.right != null){stack1.push(temp.right);}
                if(temp.left != null){stack1.push(temp.left);}
            }
        }
    }
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
    
    
    public static void main(String[] args){
        System.out.println("Hello world from Tree Traversal!!!");
        
        Node root = buildTree();
        System.out.println("Pre order Traversal:");
        preOrderTraversal(root);
        
        System.out.println("\n\nIn order Traversal:");
        inOrderTraversal(root);
        
        System.out.println("\n\nPost order Traversal:");
        postOrderTraversal(root);   
                
        System.out.println("\n\nLevel order traversal: ");
        LevelOrderTraversal(root);
        
        System.out.println("\n\nSpiral order traversal:");
        spiralTraversal(root);        
    }
}
