import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int []arr;
    public static StringBuilder sb = new StringBuilder();
    public static void back(int x, int d){
        if(d == m){
            for (int i = 0; i < d; i++) {
                sb.append(""+arr[i]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = x; i <= n; i++) {
            arr[d] = i;
            back(i+1,d+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        back(1,0);
        System.out.println(sb);
    }
}
