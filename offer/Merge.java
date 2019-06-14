package offer;

/**题目描述
 * 输入两个单调递增的链表，
 * 输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
/*
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Merge {
    public static void main(String[] args){
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6};
        Merge mer = new Merge();
        ListNode pList1 = mer.creatList(array1);
        mer.pPrintf(pList1);
        ListNode pList2 = mer.creatList(array2);
        mer.pPrintf(pList2);
        ListNode pHead = mer.merge(pList1, pList2);
        mer.pPrintf(pHead);
    }
    public ListNode creatList(int[] arr){
        ListNode list = new ListNode(arr[0]);
        ListNode pList = list;
        for(int i = 1; i < arr.length; i++){
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        return pList;
    }
    public void pPrintf(ListNode node){
        while (node != null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }
    public ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null && list2 != null)
            return list2;
        if(list1 != null && list2 == null)
            return list1;
        ListNode temp = null;
        ListNode newHead = null;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(newHead == null){
                    temp = list1;
                    newHead = temp;
                    list1 = list1.next;
                }else{
                    temp.next = list1;
                    list1 = list1.next;
                    temp = temp.next;
                }
            }
            else if(list1.val > list2.val){
                if(newHead == null){
                    temp = list2;
                    newHead = temp;
                    list2 = list2.next;
                }else{
                    temp.next = list2;
                    list2 = list2.next;
                    temp = temp.next;
                }
            }

        }
        while(list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return newHead;
    }
}
