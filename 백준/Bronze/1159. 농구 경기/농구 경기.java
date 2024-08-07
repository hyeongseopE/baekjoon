import java.io.*;
import java.util.*;

public class Main {
    static int arr[] = new int [27];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int a = s.charAt(0);
            arr[a-97]++;
        }

        for (int i = 0; i < 27; i++) {
            if(arr[i] >= 5){
                int a = i+97;
                char c = (char) a;
                sb.append(c);
            }
        }
        if(sb.length()==0){
            System.out.println("PREDAJA");
        }else{
            System.out.println(sb);
        }

    }
}