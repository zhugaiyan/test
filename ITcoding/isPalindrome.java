package coding;

import java.util.Scanner;
import java.util.Stack;

//判断一个链表是否为回文结构
//1 2 3 2 1；输出true；
//1 2 3；输出false；
class Node{
    int value;
    Node next;
    public Node(int val){
        this.value = val;
    }
}
public class isPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //构建链表
            String str = new String(sc.nextLine());
            String[] s = str.split(" ");
            Node temp = new Node(Integer.valueOf(s[0]));
            Node head = temp;
            temp.next = null;
            for(int i = 1; i < s.length; i++){
                Node pd = new Node(Integer.valueOf(s[i]));
                temp.next = pd;
                temp = temp.next;
                temp.next = null;
            }
            Stack<Integer> stack = new Stack<Integer>();
            Node cur = head;
            while(cur != null){
                stack.push(cur.value);
                cur = cur.next;
            }
            boolean flag = true;
            while(head!= null && !stack.isEmpty()){
                if(stack.pop() != head.value) {
                    flag = false;
                    break;
                    //System.out.println("false");
                    //return "false";
                }
                head = head.next;
            }
            if(flag == true)
                System.out.println("true");
            else
                System.out.println("false");
           // System.out.println("true");
            /*
            //已知链表的头节点head，判断回文结构
            //方法一：两个指针fast，slow；
            // fast一次走2步，slow一次走1步，当fast到终点时，slow到中间
            //同时count记录走的步数，判断链表长度为奇数或者偶数，奇数舍弃中间值不参与比较
            Node fast = head, slow = null;
            if(head.next != null)
                slow = head.next.next;
            else
                System.out.println("false");
            Stack<Integer> stack = new Stack<Integer>();
            int count = 1;
            stack.push(head.value);
            while(fast != null && slow != null && slow.next != null){
                fast = fast.next;
                slow = slow.next.next;
                stack.push(fast.value);
                count++;
            }
            if(slow == null)//说明有奇数个
                stack.pop();
            while(!stack.isEmpty() &&)
            */


        }
        sc.close();
    }
}
