package offer;

import java.util.Scanner;
//二维数组中的查找
/**题目描述
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */
public class Find1 {
    public static void main(String[] args){
        int tar = 7;
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Find1 find = new Find1();
        find.Find(tar, arr);

    }
    public boolean Find(int target, int [][] array) {
        if(array.length == 0)
            return false;
        int rows = array.length;
        int cols = array[0].length;
        int i = 0, j = cols - 1;
        boolean flag = false;
        while(i < rows && j >= 0){
            if(target < array[i][j])
                j--;
            else if(target > array[i][j])
                i++;
            else if(target == array[i][j]){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
