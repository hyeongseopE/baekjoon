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
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int left = 0,right = n-1;
            ans=0;
            cnt=0;
            min_Value=Integer.MAX_VALUE;
            while(left<right){
                int x = arr[left]+arr[right];
                int ans = Math.abs(k - x);
                if(min_Value > ans){
                    cnt = 1;
                    min_Value = ans;
                }else if(min_Value == ans){
                    cnt++;
                }


                if(k>x){
                    left++;
                }else if(k<x) {
                    right--;
                }else{
                    right --;
                    left++;
                }
//              System.out.println("list[j]:"+list.get(j)+"mid:"+mid+"x:"+x);

            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);







    }
}