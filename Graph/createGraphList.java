package Graph;

import java.util.Scanner;

public class createGraphList {
    private static graphList G;
    public static graphList getGraph(){
        return G;
    }
    public static void buildGraphList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点数v和边数e");
        int v = sc.nextInt();
        int e = sc.nextInt();
        G = new graphList(e, v);
        System.out.println("请输入各顶点信息：");
        for(int i = 0; i < G.vertexNum; i++){
            G.adjList[i] = new VertexNode();
            G.adjList[i].name = sc.next();
            G.adjList[i].firstedge = null;
        }
        System.out.println("请输入各边信息");
        for(int i = 0; i < G.edgeNum; i++){
            EdgeNode en1 = new EdgeNode();
            String e1 = sc.next();
            String e2 = sc.next();
            int v1 = Index(e1);
            int v2 = Index(e2);
            en1.index = v1;//en1的下标是v1
            //eg:下标0处的顶点a，边是ab（1）、ac（2）
            //则第一次输入边ab时，0处的firstedge指向b的EdgeNode;
            //而当第二次输入边ac时，0处的firstedge指向c的EdgeNode，而c的next指向b的EdgeNode
            //每次将新的弧的尾结点插入到前面
            en1.next = G.adjList[v2].firstedge;
            G.adjList[v2].firstedge = en1;

            //因为时无向图，所以得更新尾节点处的信息
            EdgeNode en2 = new EdgeNode();
            en2.index = v2;//en2的下标是v2
            en2.next = G.adjList[v1].firstedge;
            G.adjList[v1].firstedge = en2;
        }
    }
    public static void outputGraph(){
        try{
            System.out.println("输出无向图邻接表的存储情况");
            EdgeNode en = new EdgeNode();
            for(int i = 0; i < G.vertexNum; i++){
                System.out.print(G.adjList[i].name);
                en = G.adjList[i].firstedge;
                while (en != null){
                    System.out.print("->" + G.adjList[en.index].name);
                    en = en.next;
                }
                System.out.println();
            }
        }catch (NullPointerException e){
        }
    }
    public static int Index(String e1){
        for(int i = 0; i < G.vertexNum; i++){
            if(G.adjList[i].name.equals(e1))
                return i;
        }
        return -1;
    }
}
