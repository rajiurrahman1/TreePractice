package TreePractice;

/**
 *
 * @author Rajiur
 */
class HuffmanNode{
    public char data;
    public HuffmanNode left;
    public HuffmanNode right;
}

public class HuffmanCoding {
    public static void decode(String S, HuffmanNode root){
        char[] inputCharArray = S.toCharArray();
        String decodedString = "";
        HuffmanNode current = root;
        for(int i=0; i<inputCharArray.length; i++){
            if(inputCharArray[i] == '0'){
                current = current.left;
            }
            else{
                current = current.right;
            }
            if(current.left == null && current.right == null){
                decodedString = decodedString+current.data;
                current = root;
            }        
        }
        System.out.println(decodedString);
    }
    
    private static HuffmanNode buildTree(){
        HuffmanNode root = new HuffmanNode();
        HuffmanNode n1 = new HuffmanNode();
        HuffmanNode n0 = new HuffmanNode();
        HuffmanNode n00 = new HuffmanNode();
        HuffmanNode n01 = new HuffmanNode();
        
        root.data = 'x';    //x are for internal nodes which doesn't have any value
        n0.data = 'x';
        n1.data = 'A';      //Outer nodes representing A, B, and C
        n00.data = 'B';
        n01.data = 'C';

        root.left = n0;
        root.right = n1;
        n0.left = n00;
        n0.right = n01;                
        return root;
    }
        
    public static void main(String[] args){
        HuffmanNode root = buildTree();
        decode("100101", root);
        
    }
}
