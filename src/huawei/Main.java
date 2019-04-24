package huawei;
/*
* ************题目描述***********
* 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
* ************输入说明************
* 1 输入链表结点个数
*2 输入链表的值
*3 输入k的值
*
8
1 2 3 4 5 6 7 8
4
* ************输出描述************
* 输出一个整数
5
* */

import java.util.Scanner;
class ListNode{
    public int val;
    public ListNode next;
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int N = Integer.valueOf(sc.nextLine());
            ListNode node = new ListNode();
            node.next = null;
            String str = sc.nextLine();
            String[] s = str.split(" ");
            //for循环倒序存储结点，则在查找时正数第k个就是要找的倒数第k个
            for(int i = 0; i < N; i++){
                ListNode temp = new ListNode();
                temp.next = node.next;
                temp.val = Integer.valueOf(s[i]);
                node.next = temp;
            }
            int k = Integer.valueOf(sc.nextLine());
            ListNode res = FindKthToTail(node, k, N);
            String result = (res == null) ? "error" : String.valueOf(res.val);
            System.out.println(result);
        }
        sc.close();
    }
    public static ListNode FindKthToTail(ListNode head, int m, int n){
        if(m > n)
            return null;
        int j = 0;
        while(head.next != null && j < m){
            head = head.next;
            ++j;
        }
        return (j == m) ? head : null;
    }
}
