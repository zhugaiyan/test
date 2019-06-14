package Graph;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class BFSGraph {
    public static void BFSList(graphList G){
        LinkedList<Integer> queue = new LinkedList<>();
        int i;
        EdgeNode p = new EdgeNode();
        for(i = 0; i < G.vertexNum; i++){
            if(!G.visit[i]){
                G.visit[i] = true;
                System.out.print(G.adjList[i].name + " ");
                queue.addLast(i);
                while (!queue.isEmpty()){
                    int num = queue.removeFirst();
                    p = G.adjList[num].firstedge;
                    while (p != null){
                        if(!G.visit[p.index]){
                            G.visit[p.index] = true ;
                            System.out.print(G.adjList[p.index].name + " ");
                            queue.addLast(p.index);
                            //queue.remove(p.index);
                        }
                        //p = (p == null) ? null : p.next;
                        p = p.next;
                    }
                }
            }
        }
        System.out.println();
    }
}
