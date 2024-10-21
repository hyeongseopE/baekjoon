import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int []arr ;
    static int []chk = new int [10];
    static StringBuilder sb = new StringBuilder();
    static void back(int d){
        if(d==m){
            for (int i = 0; i<m;i++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(chk[i] == 1){continue;}
            chk[i] = 1;
            arr[d] = i;
            back(d+1);
            chk[arr[d]] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [m+1];


        back(0);
        System.out.println(sb);
    }

}
