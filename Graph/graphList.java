package Graph;
//邻接表实现图的建立：数组+链表
//存储边
class EdgeNode{
    int index;//顶点下标
    // int weight;//无向图没有权值
    EdgeNode next;//指向下一条弧
}
//邻接表结点类型
class VertexNode{
    String name;//存储顶点信息，eg：v0 v1 v2
    EdgeNode firstedge = new EdgeNode();//指向第一条弧
}
public class graphList {
    VertexNode[] adjList;//保存邻接表头节点
    int edgeNum;//图的边数
    int vertexNum;//图的顶点数
    boolean[] visit;//标记
    public graphList(int edgeNum, int vertexNum){
        this.edgeNum = edgeNum;
        this.vertexNum = vertexNum;
        adjList = new VertexNode[vertexNum + 1];//动态分配空间，创建顶点表数组

        //下面是DFS遍历需要的
        //数组visit长度为顶点个数，初始值为false，遍历过的设置为true
        visit = new boolean[vertexNum + 1];
        for(int i = 0; i < vertexNum; i++)//标记初始化为false
            visit[i] = false;
    }
}
