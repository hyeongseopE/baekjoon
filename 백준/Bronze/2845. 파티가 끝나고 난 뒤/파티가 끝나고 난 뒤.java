import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = a*b;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(n-m+" ");
        }
        System.out.println(sb);



    }
}