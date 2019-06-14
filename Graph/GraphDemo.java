package Graph;

public class GraphDemo {
    public static void main(String[] args){
        createGraphList.buildGraphList();
        createGraphList.outputGraph();

     //   System.out.println("DFS遍历结果：");
     //   DFSGraph.DFSList(createGraphList.getGraph(), 0);
        System.out.println("BFS遍历结果：");
        BFSGraph.BFSList(createGraphList.getGraph());
    }
}
