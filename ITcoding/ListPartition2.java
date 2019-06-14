package coding;
import java.util.Scanner;
//将单链表按值划分成左边小、中间相等、右边大
//方法一：时间复杂度和空间复杂度均为o（n）,借助数组实现，基于快排思想

class Node3{
    public int value;
    public Node3 next;
    public Node3(int val){
        this.value = val;
    }
}
//将单链表按值划分成左边小、中间相等、右边大，且保证每部分结点从左到右的顺序保持不变
//时间复杂度O（n），空间复杂度O（1）
//方法二：方法一的改进，基于3组连表实现
public class ListPartition2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //获取输入数据
            String str = new String(sc.nextLine());
            String[] s = str.split(" ");
            int pivot = Integer.valueOf(sc.nextLine());
            //根据输入创建链表
            Node3 head = new Node3(Integer.valueOf(s[0]));
            head.next = null;
            Node3 temp = head;
            for(int i = 1; i < s.length; i++){
                Node3 node = new Node3(Integer.valueOf(s[i]));
                temp.next = node;
                temp = temp.next;
                temp.next = null;
            }
            Node3 p = head;
            while(p != null){
                System.out.print(p.value + " ");
                p = p.next;
            }
            System.out.println();
            Node3 nodeHead = listPartition2(head, s.length, pivot);
            while(nodeHead != null){
                System.out.print(nodeHead.value + " ");
                nodeHead = nodeHead.next;
            }
            System.out.println();
        }
        sc.close();
    }
    public static Node3 listPartition2(Node3 head, int len, int pivot){
        Node3 small = null;
        Node3 big = null;
        Node3 equal = null;
        Node3 bigHead = null;
        Node3 equalHead = null;
        Node3 smallHead = null;
        Node3 temp = head;
        while(temp != null){
            if(temp.value < pivot){
                if(smallHead == null){
                    small = temp;
                    smallHead = temp;
                }else{
                    small.next = temp;
                    small = small.next;
                }
            }else if(temp.value == pivot){
                if(equalHead == null){
                    equal = temp;
                    equalHead = temp;
                }else{
                    equal.next = temp;
                    equal = equal.next;
                }
            }else{
                if(bigHead == null){
                    big = temp;
                    bigHead = temp;
                }else{
                    big.next = temp;
                    big = big.next;
                }
            }
            temp = temp.next;
        }
        if(small != null){
            small.next = equalHead;
            equal = equal == null ? small : equal;
        }
        if(equal != null){
            equal.next = bigHead;
        }
        return smallHead != null ? smallHead : equalHead == null ? bigHead : equalHead;
    }
}
