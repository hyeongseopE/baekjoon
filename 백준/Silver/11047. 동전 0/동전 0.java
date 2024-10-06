import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<String,String> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int [n];

        int index = -1;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            if(x > m && index == -1)  {
                index = i-1;
            }
        }
        if(index == -1){
            index = n-1;
        }

        int pay = 0;
        int cnt = 0;

        while(true){
            if(pay == m){break;}

            if(pay + arr[index] > m){
                index --;
                continue;
            }
            pay += arr[index];
            cnt ++;
        }


        System.out.println(cnt);
    }
}