package TreePractice;

/**
 *
 * @author Rajiur
 */
public class BinarySearchTrees {
    public static Node Insert(Node root, int value){
        Node current = root;
        while(true){
            if(value < current.getData()){
                if(current.left != null){current = current.left;}
                else{break;}
            }
            else{
                if(current.right != null){current = current.right;}
                else{break;}
            }
        }
        Node temp = new Node();
        temp.setData(value);
        temp.left = null; temp.right = null;
        if(value < current.getData()){
            current.left = temp;
        }
        else{
            current.right = temp;
        }
        return root;       
    }
    public static void deleteNode(Node root, int value){
        // complex method with recursion
        // case 1: remove a leaf node, easy as hell
        // case 2: node has one child. Pretty easy. just return root.left or right from the recursive cal
        // case 3: node has two children. DIFFICULT
            //      Find the lowest value from the right subtree and replace that with 'value' dealete that node
    }
    private static Node buildTree(){
        Node root = new Node();
        Node n4 = new Node();
        Node n12 = new Node();
        Node n2 = new Node();
        Node n9 = new Node();
        Node n21 = new Node();
        Node n1 = new Node();
        Node n3 = new Node();
        Node n19 = new Node();
        Node n25 = new Node();
        root.setData(5);
        n4.setData(4);
        n12.setData(12);
        n2.setData(2);
        n9.setData(9);
        n21.setData(21);
        n1.setData(1);
        n3.setData(3);
        n19.setData(19);
        n25.setData(25);
        
        root.left = n4;
        root.right = n12;
        n4.left = n2;
        n12.left = n9;
        n12.right = n21;
        n2.left = n1;
        n2.right = n3;
        n21.left = n19;
        n21.right = n25;
        
        return root;
    }   
    public static int levelWidth(Node root, int depth){
        //the depth of tree root is considered 0
        if(root == null){
            return 0;
        }
        else{
            if(depth == 0){
                return 1;
            }
            else{
                return levelWidth(root.left, depth-1) + levelWidth(root.right, depth-1);
            }
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        else{
            return 1+Math.max(height(root.left), height(root.right));
        }
    }
    public static int countLeaves(Node root){
        if(root == null){
            return 0;
        }
        else{
            if(root.left == null && root.right == null){
                return 1;
            }
            else{
                return countLeaves(root.left) + countLeaves(root.right);
            }
        }
    }
    public static int searchElement_iterative(Node root, int value){ //iterative
        int res = 0; //default not found
        Node current = root;
        while(true){
            if(current.getData() == value){
                res = 1;
                break;
            }
            if(current.left == null && current.right == null){
                break;
            }
            if(value < current.getData()){
                if(current.left != null){current = current.left;}
                else{break;}
            }
            if(value > current.getData()){
                if(current.right != null){current = current.right;}
                else{break;}
            }              
        }
        return res;
    }
    public static int searchElement_recursive(Node root, int value){
        if(root.getData() == value){return 1;}
        if(root.getData() != value && (root.left == null && root.right==null) ) {return 0;}
        if(value < root.getData()){
            if(root.left != null){
                return searchElement_recursive(root.left, value);
            }
            else{return 0; }
        }
        else if(value > root.getData()){
            if(root.right != null){
                return searchElement_recursive(root.right, value);
            }
            else{return 0;}
        }
        return 0;        
    }
    public static int sumLeaves(Node root){
        if(root.left == null && root.right == null){
            return root.getData();
        }
        else{
            if(root.left != null & root.right != null){
                return sumLeaves(root.left)+sumLeaves(root.right);
            }
            else if(root.left == null){
                return sumLeaves(root.right);
            }
            else return sumLeaves(root.left);            
        }
    }
    public static int sumInternalNodes(Node root){
        if(root.left == null && root.right == null){return 0;}
        else{
            if(root.left != null && root.right != null){
                return root.getData()+sumInternalNodes(root.left)+sumInternalNodes(root.right);
            }
            else if(root.left == null){
                return root.getData()+sumInternalNodes(root.right);
            }
            else{
                return root.getData()+sumInternalNodes(root.left);
            } 
        }
    }
    public static boolean isCousin(Node root, Node a, Node b){
        //two nodes are cousins if they are at same depth but their parents are different
        //first calculate the height of the two nodes
        //if height is same check the paretns 
        return true;
    }
    public static void printBSTRange_recursive(Node root, int min, int max){
        //System.out.println("-- " + root.getData());
        if(root == null){return;}
        if(root.getData() > min && root.getData() < max){
            System.out.println(root.getData());
        }
        if(root.getData() < max ){   // the root is less 
            if(root.left != null){ printBSTRange_recursive(root.right, min, max);}
            else return;
        }
        if(root.getData() > min){
            if(root.left != null){printBSTRange_recursive(root.left, min, max);}
            else return;
        }
    }
    public static void printBSTRange_iterative(Node root, int min, int max){
        //simple
        //traverse the whoel tree and insert all the values in Queue
        //pop the queue untill empty, print the values inside range
    }
    public static boolean isSameTree(Node root1, Node root2){
        if(root1 == null && root2 == null){return true;}
        else if( (root1 == null && root2 != null) || (root2 == null && root1 != null) ) {return false;}
        else{
            return ( (root1.getData() == root2.getData()) 
                    && (isSameTree(root1.left, root2.left)) 
                    && (isSameTree(root1.right, root2.right))  );
        }
    }
    public static Node deleteLeaves(Node root){
        
            if(root.left == null && root.right == null){
                root = null;
                return null;
            }
            else{
                if(root.left != null){root.left = deleteLeaves(root.left);}
                if(root.right != null){root.right = deleteLeaves(root.right);}
            }
        
        return root;
    }
//    public static Node deleteLeaves_iterative(Node root){
//        //should be easy
//        
//    }
    
    public static void main(String[] args){
        Node root = buildTree();
        System.out.println("Height: "+ height(root));
        System.out.println("Total leaves: "+ countLeaves(root));
        int depth = 1; //root is at depth=0
        System.out.println("Total nodes at deapth "+ depth + " is: " + levelWidth(root, depth) );
        
        System.out.println( searchElement_recursive(root,26) );
        System.out.println("Sum of leaf nodes: "+sumLeaves(root));
        System.out.println("Sum of internal nodes: "+sumInternalNodes(root));
        
//        printBSTRange_recursive(root, 2, 22);
        System.out.println(isSameTree(root.left, root.left));
//        Node deletedLeavesRoot = deleteLeaves(root);
//        System.out.println("Height after deleting leaves: "+ height(deletedLeavesRoot));
        
        
    }
}
