package coding;

import java.util.Scanner;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CloneList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = new String(sc.nextLine());
            String[] s = str.trim().split(" ");
            RandomListNode head = new RandomListNode(Integer.valueOf(s[0]));
            RandomListNode ph = head;
            for(int i = 1; i < s.length; i++){
                RandomListNode node = new RandomListNode(Integer.valueOf(s[i]));
                ph.next = node;
                ph = ph.next;
            }
            RandomListNode pOne = head;
            pOne.random = head.next.next;
            pOne = pOne.next;
            pOne.random = head.next.next.next;
            RandomListNode pr = head;
            while(pr != null){
                System.out.print(pr.label + " ");
                pr = pr.next;
            }
            System.out.println();
            RandomListNode res = Clone(head);
            while(res != null){
                System.out.print(res.label + " ");
                if(res.random != null)
                    System.out.print(res.random.label + " ");
                res = res.next;
            }
            System.out.println();
        }
        sc.close();
    }
    public static RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        //复制
        RandomListNode pH = pHead;
        while(pH != null){
            RandomListNode node = new RandomListNode(pH.label);
            node.next = pH.next;
//            node.random = pH.random == null ? null : pH.random.next;
            //不可以在这里复制random指针，因为可能不存在
            pH.next = node;
            pH = node.next;
        }
        //复制随机指针
        pH = pHead;
        RandomListNode pRandom = null;
        while(pH != null){
            pH.next.random = pH.random == null ? null : pH.random.next;
            pH = pH.next.next;
        }
        //拆分
        RandomListNode pFirst = pHead;
        RandomListNode pSecond = pHead.next;
        pH = pSecond;
        while(pSecond.next != null){
            pFirst.next = pSecond.next;
            pFirst = pFirst.next;
            pSecond.next = pFirst.next;
            pSecond = pSecond.next;
        }
        return pH;
    }

    /*
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        //复制
        RandomListNode pH = pHead;
        while(pH != null){
            RandomListNode node = new RandomListNode(pH.label);
//            RandomListNode pNext = pH.next;
//            RandomListNode pRandom = pH.random;
//            pH.next = node;
            node.next = pH.next;
      //      node.random = pH.random == null ? null : pH.random.next;
            pH.next = node;
            pH = node.next;
        }
        pH = pHead;
        RandomListNode pRandom = null;
        while(pH != null){
            pH.next.random = pH.random == null ? null : pH.random.next;
            pH = pH.next.next;
        }
        RandomListNode pf = pHead;
        while(pf != null){
            System.out.print(pf.label + " ");
            pf = pf.next;
        }
        System.out.println();
        //拆分
        RandomListNode pFirst = pHead;
        RandomListNode pSecond = pHead.next;
        RandomListNode pRes = pSecond;
        while(pSecond.next != null){
            pFirst.next = pSecond.next;
            pFirst = pFirst.next;
            pSecond.next = pFirst.next;
            pSecond = pSecond.next;
        }
        return pRes;
    }*/
}
