package huawei;
import java.util.Scanner;

public class CountLenOfLastword {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s.length() == 0)
            System.out.println(-1);
        String[] str = s.split(" ");
        int len = str.length;
        int count = str[len - 1].length();
        //str.length - 1是求数组的长度，str[].length()是求字符串的长度
        System.out.println(count);
        sc.close();
        /*
       System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s.length() == 0)
            System.out.println(-1);
        String[] str = s.split(" ");
        int len = str.length - 1;
        int count = str[len - 1].length();
        System.out.println(count);
        sc.close();*/
        /*
        int len = s.trim().length();
        StringBuffer str = new StringBuffer();
        while (len >= 0) {
            str.append(s.charAt(len));
            len--;
        }
        int i = 0;
        char tp = str.charAt(i);
        while(!((tp >= 'a' && tp <= 'z') || (tp >= 'A' && tp <= 'Z'))){
            i++;
            tp = str.charAt(i);
        }
        int count = 0;
        while(tp != ' '){
            i++;
            tp = str.charAt(i);
            count++;
        }*/

    }
}


