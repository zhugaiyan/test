package coding;

import java.util.Scanner;
import java.util.Stack;
//两个单链表生成相加链表
//即链表1的结点的值：1 2 3 4
//链表2的结点的值： 2 3 6
//输出结果:1470
class ListNode{
    int value;
    ListNode next;
    public ListNode(int val){
        this(val, null);
    }
    public ListNode(int val, ListNode nex){
        this.value = val;
        this.next = nex;
    }
}

public class addList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = new String(sc.nextLine());
            String str2 = new String(sc.nextLine());
            String[] s1 = str1.trim().split(" ");
            String[] s2 = str2.trim().split(" ");
            ListNode head1 = creatList(s1);
            ListNode head2 = creatList(s2);
            addTwoList(head1, head2);
        }
    }
    public static void addTwoList(ListNode pHead1, ListNode pHead2){
        //防止溢出，则用栈存储结果
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        ListNode pH1 = pHead1;
        ListNode pH2 = pHead2;
        while(pH1 != null){
            stack1.push(pH1.value);
            pH1 = pH1.next;
        }
        while(pH2 != null){
            stack2.push(pH2.value);
            pH2 = pH2.next;
        }
        int sum = 0;
       // Stack<Integer> stack = new Stack<Integer>();
        int data = -1;
        ListNode nodeH = null;
        ListNode nodeP = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop() + stack2.pop() + sum / 10;//两数相加，加进位
            //stack.push(sum % 10);//余数进栈
            nodeP = nodeH;
            nodeH = new ListNode(sum % 10);
            nodeH.next = nodeP;
        }
 //       if(!stack1.isEmpty()){
        while(!stack1.isEmpty()){
            if((sum / 10) != 0) {
                sum = sum / 10 + stack1.pop();
               // stack.push(sum % 10);
                data = sum % 10;
            }else
                data = stack1.pop();//stack.push(stack1.pop());
            nodeP = nodeH;
            nodeH = new ListNode(data);
            nodeH.next = nodeP;

        }
  //          if(sum / 10 != 0)
 //               stack.push(sum);
   //     }else if(!stack2.isEmpty()){
        while(!stack2.isEmpty()){
            if((sum / 10) != 0) {
                sum = sum / 10 + stack2.pop();
                //stack.push(sum % 10);
                nodeP = nodeH;
                nodeH = new ListNode(data);
                nodeH.next = nodeP;
            }else
                data = stack2.pop();//stack.push(stack2.pop());
            nodeP = nodeH;
            nodeH = new ListNode(data);
            nodeH.next = nodeP;
        }
        if(sum / 10 != 0){
            nodeP = nodeH;
            nodeH = new ListNode(sum);
            nodeH.next = nodeP;
        }
            //data = sum;
        //stack.push(sum);
     //   }
      //  while(!stack.isEmpty()){//将结果存入栈中，由于是从低位到高位依次存储
        while(nodeH != null){
           // System.out.print(stack.pop());
            System.out.print(nodeH.value);
            nodeH = nodeH.next;
        }
    }
    public static ListNode creatList(String[] s){
        int len = s.length;
        if(len == 0)
            return null;
        ListNode node = new ListNode(Integer.valueOf(s[0]));
        ListNode head = node;
        for(int i = 1; i < len; i++){
            node.next = new ListNode(Integer.valueOf(s[i]));
            node = node.next;
        }
        ListNode testNode = head;
        while(testNode != null){
            System.out.print(testNode.value);
            testNode = testNode.next;
        }
        System.out.println();
        return head;
    }
}
