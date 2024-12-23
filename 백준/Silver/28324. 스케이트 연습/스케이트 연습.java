import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int []arr = new int [n];
        long ans = 0;
        long count = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-1; i >= 0 ; i--) {
            if(arr[i] > count ){
                count ++;
            }else if(arr[i] < count) {
                count = arr[i];
            }
            ans += count;
        }
        System.out.println(ans);

    }
}

