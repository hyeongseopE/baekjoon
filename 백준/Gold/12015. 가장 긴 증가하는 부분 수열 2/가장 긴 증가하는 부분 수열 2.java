import java.io.*;
import java.util.*;
import java.util.Stack;


public class Main {
    static int n;
    static int []arr;
    static int []dp;

    public static int lower(int left, int right, int target){

        while(left <= right){
            int mid = (left+right)/2;
            if(dp[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int [n+1];
        dp = new int [n+1];
        int size = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if(dp[size-1] < arr[i]){
//                System.out.println(i+"번째 :"+arr[i]);
                dp[size] = arr[i];
                size ++;
            }else{
                int lowerIndex = lower(1,size-1,arr[i]);
//                System.out.println(lowerIndex+"번째 인덱스에:"+i+"번째값 교체");
                dp[lowerIndex] = arr[i];
            }
        }


        System.out.println(size-1);


    }
}


