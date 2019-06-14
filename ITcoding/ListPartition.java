package coding;
import java.util.Scanner;
class Node1{
    public int value;
    public Node1 next;
    public Node1(int val){
        this.value = val;
    }
}
//将单链表按值划分成左边小、中间相等、右边大
//方法一：时间复杂度和空间复杂度均为o（n）,借助数组实现，基于快排思想
public class ListPartition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = new String(sc.nextLine());
            int pivot = Integer.valueOf(sc.nextLine());
            String[] s = str.split(" ");
            for(int j = 0; j < s.length; j++){
                System.out.print(s[j] + " ");
            }
            System.out.println();
            //创建链表，并获取链表的长度
            int lengthList = s.length;
            Node1 head = new Node1(Integer.valueOf(s[0]));
            head.next = null;
            Node1 temp = head;
            for(int i = 1; i < lengthList; i++){
                Node1 node = new Node1(Integer.valueOf(s[i]));
                temp.next = node;
                temp = temp.next;
                temp.next = null;
            }
            Node1 test = head;
            while(test != null){
                System.out.print(test.value + " ");
                test = test.next;
            }
            System.out.println();
            //不用遍历链表，在创建时就可以得知链表的长度
            //创建数组，存放结点，其实可以直接将结点存放在数组中，排序后连接
            Node1 newHead = listPartition(head, lengthList, pivot);
            while(newHead != null){
                System.out.print(newHead.value + " ");
                newHead = newHead.next;
            }
        }
        sc.close();
    }
    public static Node1 listPartition(Node1 head, int len, int pivot){
        Node1[] nodeArr = new Node1[len];
        Node1 tp = head;
        //将结点存进数组
        for(int i = 0; i < len; i++){
            nodeArr[i] = tp;
            tp = tp.next;
        }
        //调整结点位置
        int index = 0;
        int big = len;
        int small = -1;//存放小于pivot的下标数
        while(index != big){
            if(nodeArr[index].value < pivot)
                swap(nodeArr, ++small, index++);
            else if(nodeArr[index].value == pivot)
                index++;
            else if(nodeArr[index].value > pivot)
                swap(nodeArr, --big, index);
        }
        //将各结点连接
        for(int i = 0; i < len - 1; i++){
            nodeArr[i].next = nodeArr[i + 1];
        }
        nodeArr[len - 1].next = null;
        return nodeArr[0];
    }
    public static void swap(Node1[] arr, int start, int end){
        Node1 temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
