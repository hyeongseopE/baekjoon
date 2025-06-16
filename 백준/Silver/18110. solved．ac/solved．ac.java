import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int []arr = new int [n];
        double ans = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            ans += arr[i];
        }

        Arrays.sort(arr);

        int x = (int)Math.round(n*0.15); // 절사평균 인원

        for (int i = 0; i < n; i++) {
            if(i < x || i >= n-x){
                ans -= arr[i];
            }
        }

        System.out.println((int) Math.round(ans/(n-(x*2))));

    }
}


