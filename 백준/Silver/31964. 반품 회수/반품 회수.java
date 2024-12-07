import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       StringTokenizer st2;

       int ans = 0;
       int n = Integer.parseInt(br.readLine());
       int [] t = new int [n+1];
       int [] x = new int [n+1];
       st = new StringTokenizer(br.readLine());
       st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st2.nextToken());
        }
        if(x[n-1] < t[n-1]){
            ans = t[n-1];
        }else{
            ans = x[n-1];
        }
        for (int i = n-2; i >= 0; i--) {
            ans += x[i+1] - x[i];
            if(ans < t[i]){
                ans = t[i];
            }
        }
        System.out.println(ans += x[0]);
    }
}
