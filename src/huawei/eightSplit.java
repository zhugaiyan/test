package huawei;

import java.util.Scanner;

public class eightSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = new String(sc.nextLine());
            if (str == null)
                return;
            if (str.length() % 8 != 0) {
                str = str + "00000000";
            }
            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));//返回0-8位置的元素，不包括8处的
                str = str.substring(8);//表返回从8到末尾的元素
            }
        }
        sc.close();
    }
    /*
    法二：
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if(str1 != null)
            return;
            //nPrint(str1);
        if(str2 != null)
            nPrint(str2);
    }
    public static void nPrint(String s){
        int len = s.length();
        int num = len / 8;
        int mod = len % 8;
        int i = 0, index = 0;
        while(i < num){
            int j = 0;
            while(j < 8){
                System.out.print(s.charAt(index++));
                j++;
            }
            i++;
            System.out.println();
        }
        if(mod != 0){
            while(index < len){
                System.out.print(s.charAt(index++));
            }
            int t = 0;
            while(t < 8 - mod){
                System.out.print('0');
                t++;
            }
        }
        System.out.println();
    }*/
}
