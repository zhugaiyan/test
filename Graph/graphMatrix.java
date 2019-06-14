package Graph;

import java.util.Scanner;

public class graphMatrix {
    static final int MaxNum = 20;//图的最大顶点数
    static final int MaxValue = 65535;//最大值，用65535代替∞
    class getMaterix{
        int GType;//图的类型，可以不用;表示无向图、1表示有向图
        int VertexNum;//顶点的数量
        int EdgeNum;//边的数量
        String[] Vertex = new String[MaxNum];
        // char[] Vertex = new char[MaxNum];//保存顶点信息
        int[][] EdgeWeight = new int[MaxNum][MaxNum];//保存权值信息，邻接矩阵
    }
    public static void main(String[] args){//创建并初始化无向图
        //  int gType;
        int startV, endV, weight;//起始、终止顶点、权
        Scanner sc = new Scanner(System.in);
        graphMatrix.getMaterix gm = new graphMatrix().new getMaterix();//内部类的引用
        System.out.println("图的类型，0表示无向图，1表示有向图：");
        while(sc.hasNextLine()){
            //   System.out.println("图的类型，0表示无向图，1表示有向图：");
            gm.GType = Integer.valueOf(sc.nextLine().trim());
            System.out.println("请顶点数：");
            gm.VertexNum = Integer.valueOf(sc.nextLine().trim());
            System.out.println("请输入顶点信息：");
            String str = sc.nextLine().trim();//String.trim()去除字符串前后的空格
            String[] s = str.split(" ");
            for(int i = 0; i < gm.VertexNum; ++i){
                gm.Vertex[i] = s[i];
            }
            System.out.println("请输入边数：");
            gm.EdgeNum = Integer.valueOf(sc.nextLine().trim());
            for(int x = 0; x < gm.VertexNum; ++x) {//初始化邻接矩阵
                for (int y = 0; y < gm.VertexNum; ++y) {
                    gm.EdgeWeight[x][y] = MaxValue;
                }
            }
            for(int k = 0; k < gm.EdgeNum; ++k) {
                System.out.println("请依次输入边的起点下标、终点下标以及权值：");
                String strw = sc.nextLine().trim();
                String[] sw = strw.split(" ");
                startV = Integer.valueOf(sw[0]);
                endV = Integer.valueOf(sw[1]);
                weight = Integer.valueOf(sw[2]);
                gm.EdgeWeight[startV][endV] = weight;
                if (gm.GType == 0)
                    gm.EdgeWeight[endV][startV] = weight;
            }
            showGraph(gm);
            //deleteGraph(gm);
            //showGraph(gm);
            System.out.println();
        }
        sc.close();
    }
    /*
        static void deleteGraph(GarphMaterix gm){//将邻接矩阵中的值设置为65535
            for(int i = 0; i < gm.VertexNum; ++i){
                for(int j = 0; j < gm.VertexNum; ++j){
                    gm.EdgeWeight[i][j] = MaxValue;
                }
            }
        }*/
    static void showGraph(getMaterix gm){
        //System.out.println("图的顶点的个数："  + gm.VertexNum + "/n" + "图的顶点：");
        System.out.println(gm.VertexNum);
        for(int i = 0; i < gm.VertexNum; ++i){
            System.out.print(gm.Vertex[i] + " ");
        }
        //System.out.println("图的边的个数：" + gm.EdgeNum + "/n" + "图的邻接矩阵：");
        System.out.println(gm.EdgeNum);
        for(int i = 0; i < gm.VertexNum; ++i){
            for(int j = 0; j < gm.VertexNum; ++j){
                System.out.print(gm.EdgeWeight[i][j] + " ");
            }
            System.out.println();
        }
    }
}



