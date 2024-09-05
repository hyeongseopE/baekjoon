import java.io.*;
import java.util.*;

public class Main {
    static int t,n,k,ans,min_Value=Integer.MAX_VALUE,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int arr[] = new int [n];
            int arr2[] = new int [k];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            cnt = 0;
            ans = 0;
            for (int j = 0; j < k; j++) {
                int left = 0,right = n-1;
                while(left<=right){
                    int mid = (left+right)/2;

                    if(arr2[j] >= arr[mid]){
                        left = mid + 1;

                    }else if (arr2[j] < arr[mid]){
                        right = mid - 1;
                    }
                }
                ans += (n-right-1);
            }
            sb.append(ans).append("\n");


        }

        System.out.println(sb);







    }
}