package huawei;
import java.util.Scanner;
public class NumOfChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String tp = sc.nextLine();
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0; i < str.length; i++){
            if(tp.equalsIgnoreCase(String.valueOf(str[i])))
                count++;
        }
        /*
        String[] str = s.split(" ");
        String tpr = tp.trim().toLowerCase();
        char ch = tpr.charAt(tpr.length() - 1);
        int count = 0;
        int lenStr = str.length;
        for(int i = 0; i < lenStr; i++){
            String temp = str[i].toLowerCase();
            for(int j = 0; j < temp.length(); j++){
                if(ch == temp.charAt(j))
                    count++;
            }
        }*/
        System.out.println(count);
        sc.close();
    }
}
