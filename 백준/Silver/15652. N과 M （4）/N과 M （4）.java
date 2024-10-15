import java.io.*;
import java.util.*;

public class Main {
   static int n,m;
   static int []arr;
   static StringBuilder sb = new StringBuilder();

   public static void back(int x,int d){
       if(d == m){
           for (int i = 0; i < d; i++) {
               sb.append(arr[i]+" ");
           }
           sb.append("\n");
           return;
       }

       for (int i = x; i <= n; i++) {
           arr[d]=i;
           back(i,d+1);
       }
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [m+1];
        back(1,0);

        System.out.println(sb);

    }

}
