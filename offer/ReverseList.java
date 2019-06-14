package offer;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        ListNode node1 = null, head1 = null;
        for(int i = 0; i < arr.length; i++){
            if(node1 == null){
                head1 = new ListNode(arr[i]);
                node1 = head1;
            }else {
                node1.next = new ListNode(arr[i]);
                node1 = node1.next;
            }
        }
        ListNode head2 = head1;
        while(head2 != null){
            System.out.print(head2.val);
            head2 = head2.next;
        }
        System.out.println();
        ReverseList reverse = new ReverseList();
        reverse.reverseList(head1);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode pHead = stack.pop();
        ListNode node = pHead;
        while(!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }
        System.out.println(pHead.val);
        return pHead;
    }
}
