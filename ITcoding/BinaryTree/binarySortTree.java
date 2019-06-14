package coding.BinaryTree;
import java.util.LinkedList;

public class binarySortTree {
    private Node root;
    public binarySortTree(){
        root = null;
    }
    public static void main(String[] args){
        binarySortTree binTree = new binarySortTree();
        int[] data = {6, 8, 15, 4, 9, 12, 1, 2, 7, 5};
        for(int i = 0; i < data.length; i++){
            binTree.insert(data[i]);
        }
        binTree.preOrder();
        System.out.println();
        binTree.inOrder();
        System.out.println();
        binTree.postOrder();
        System.out.println();
        binTree.cengxuOrder();
        System.out.println();

        Node addOne = new Node(10);
        Node res = binTree.addNode(binTree.root, addOne);
        binTree.cengxuOrder(res);
        System.out.println();
        binTree.inOrder(res);
        System.out.println();
        Node searchOne = new Node(50);
        Node searchRes = binTree.search(binTree.root, searchOne);
        if(searchRes == null)
            System.out.println("false");
        else
            System.out.println(searchRes.value);

        Node deleteOne = new Node(7);
        Node deleteRes = binTree.deleteNode(binTree.root, deleteOne);
        binTree.cengxuOrder(deleteRes);
        System.out.println();
    }

    //二叉排序树的创建
    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(data < current.value){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
//二叉树前序遍历
    public void preOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
    public void preOrder(){
        this.preOrder(this.root);
    }
    //二叉树中序遍历
    public void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }
    public void inOrder(){
        this.inOrder(this.root);
    }
    //二叉树后续遍历
    public void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.value + " ");
    }
    public void postOrder(){
        this.postOrder(this.root);
    }
    //层序遍历,借助队列完成
    public void cengxuOrder(Node node){
        if(node == null)//注意判断是否为空树
            return;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(node);//put进根节点
        while(!queue.isEmpty()){
            Node temp = queue.pollFirst();
            System.out.print(temp.value + " ");
            if(temp.leftChild != null){
                queue.addLast(temp.leftChild);
            }
            if(temp.rightChild != null){
                queue.addLast(temp.rightChild);
            }
        }
    }
    public void cengxuOrder(){
        this.cengxuOrder(this.root);
    }

//二叉排序树添加结点
    public Node addNode(Node root, Node p){
        if(root == null){
            root = p;
            return root;
        }
        Node temp = root;
        while(temp != null){
            if(temp.value < p.value){
                if(temp.rightChild != null){
                    temp = temp.rightChild;
                }else{
                    temp.rightChild = p;
                    break;
                }
            }else{
                if(temp.leftChild != null){
                    temp = temp.leftChild;
                }else{
                    temp.leftChild = p;
                    break;
                }
            }
        }
        return root;
    }
    //二叉排序树删除结点
    //1、查找:用层序遍历查找
    //2、删除
    public Node search(Node root, Node pb){
        if(root == null)
            return null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        Node flag = null;
        while(!queue.isEmpty()){
            Node temp = queue.pollFirst();
            if(temp.value == pb.value){
                flag = temp;
                break;
            }
            if(temp.leftChild != null){
                //temp = temp.leftChild;
                queue.addLast(temp.leftChild);
            }
            if(temp.rightChild != null){
                //temp = temp.rightChild;
                queue.addLast(temp.rightChild);
            }
        }
        return flag;
    }
   /* public Node searchMin(Node rootRight){
        while (rootRight.leftChild != null){
            rootRight = rootRight.leftChild;
        }
    }*/
    public Node deleteNode(Node root, Node p){
        if(root == null)
            return null;
        Node pSearch = search(root, p);
        if(pSearch == null)
            System.out.println("要删除的结点不存在");
        else{
            if(pSearch.leftChild == null && pSearch.rightChild == null)
                pSearch = null;
            else if(pSearch.leftChild != null && pSearch.rightChild == null)
                pSearch = pSearch.leftChild;
            else if(pSearch.rightChild == null && pSearch.rightChild != null)
                pSearch = pSearch.rightChild;
            else{
                Node rightRoot = pSearch.rightChild;
                while(rightRoot.leftChild != null){
                    rightRoot = rightRoot.leftChild;
                }
                pSearch = rightRoot;
                rightRoot = null;
            }
        }
        return root;
    }
}
