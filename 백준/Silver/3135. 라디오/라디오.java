import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int [] arr = new int[n+1];
        arr [0] = a;
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int  m = 0;
        int min_value = arr[0] - b;
        for (int i = 1; i <= n; i++) {
            int v = arr[i] - b;
            if(Math.abs(min_value) > Math.abs(v)){
                min_value = v;
                m = i;
            }
        }

        if(m >0){
            cnt=1;
        }

        cnt = cnt + Math.abs((b - arr[m]));


        System.out.println(cnt);









    }
}