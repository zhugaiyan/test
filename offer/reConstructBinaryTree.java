package offer;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class reConstructBinaryTree {
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree res = new reConstructBinaryTree();
        TreeNode root = res.reConstructBT(pre, in);
        System.out.println(root.val);

    }
    public TreeNode reConstructBT(int [] pre,int [] in) {
        if(pre == null || in == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        TreeNode root = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
        return root;
    }
    public TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn,
                       HashMap<Integer, Integer> map){
        if(startPre < endPre)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        int index = map.get(pre[startPre]);
        root.left = reConstruct(pre, startPre + 1, startPre + index - startIn, in, startIn, index - 1, map);
        root.right = reConstruct(pre, startPre + index - startIn + 1, endPre, in, index + 1, endIn, map);
        return root;
    }
}
