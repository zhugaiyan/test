package coding.BinaryTree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class creatTree {
    public static Node creatT(int[] array){
        int len = array.length;
        LinkedList<Node> nodeList = new LinkedList<Node>();
     //   Node root = null;
        for(int i = 0; i < len; i++){
            nodeList.addLast(new Node(array[i]));
        }
        for(int index = 0; index < len / 2 - 1; index++){
            nodeList.get(index).leftChild = nodeList.get(index * 2 + 1);
            nodeList.get(index).rightChild = nodeList.get(index * 2 + 2);
        }
        int lastIndex = len / 2 - 1;
        nodeList.get(lastIndex).leftChild = nodeList.get(lastIndex * 2 + 1);
        if(len % 2 == 1){
            nodeList.get(lastIndex).rightChild = nodeList.get(lastIndex * 2 + 2);
        }
        return nodeList.get(0);
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node bRoot = creatT(arr);
        preOrder(bRoot);
        System.out.println();
        inOrder(bRoot);
        System.out.println();
        postOrder(bRoot);
        System.out.println();
        levelOrder(bRoot);

    }
    //前序遍历
    public static void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.value + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.leftChild);
        System.out.print(root.value + " ");
        inOrder(root.rightChild);
    }
    //后续遍历
    public static void postOrder(Node root){
        if(root == null)
            return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.value + " ");
    }
    //层序遍历
    public static void levelOrder(Node root){
        if(root == null)
            return;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                Node temp = queue.pollFirst();
                System.out.print(temp.value + " ");
                if(temp.leftChild != null) queue.addLast(temp.leftChild);
                if(temp.rightChild != null) queue.addLast(temp.rightChild);
            }
        }
    }
}
