import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int []arr = new int[n+1];
        int ans = 100_001;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int t = arr[0];
        int size = right - left;
        while(right < n){


            if(t < s){
                right ++;
                t+=arr[right];
            } else if(t >= s){
                if(ans > right - left){
                    ans = right - left + 1;
                }
                t-=arr[left];
                left ++;

            }
        }


        if(ans > 100_000){
            System.out.println("0");
        }else{
            System.out.println(ans);
        }


    }
}


