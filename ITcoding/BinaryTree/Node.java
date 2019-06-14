package coding.BinaryTree;

public class Node {
    public int value;
    public Node leftChild;
    public Node rightChild;
    public Node(int val){
        this(val, null, null);
    }
    public Node(int val, Node left, Node right){
        this.value = val;
        this.leftChild = left;
        this.rightChild = right;
    }
}
