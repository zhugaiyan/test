package Graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;

//图的遍历：从图的某一顶点出发遍历图中其余顶点，且每一个顶点仅被访问一次
//DFS深度优先遍历
public class DFSGraph {
    //参数为构建的图G，和任意顶点下标k
    public static void DFSList(graphList G, int k){
        System.out.print(G.adjList[k].name + " ");//下标为k的顶点的名字
        G.visit[k] = true;
        EdgeNode p = new EdgeNode();
        p = G.adjList[k].firstedge;
        while(p != null){
            if(G.visit[p.index] != true){
                DFSList(G, p.index);
            }
            p = p.next;
        }
    }
    public static void DFSMatrix(){

    }

}
