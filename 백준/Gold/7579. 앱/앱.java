import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Process{
        int m,c;
        public Process(int m,int c){
            this.m=m;
            this.c=c;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringTokenizer st2;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;

        ArrayList<Process> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st2.nextToken());
            list.add(new Process(x,p));
            sum += p;
        }

        int []dp = new int[sum + 1];

        for (int i = 1; i <= n; i++) {
            Process process = list.get(i-1);
            for (int j = sum; j >= process.c ; j--) {
                dp[j] = Math.max(dp[j],dp[j - process.c] + process.m);
            }
        }

        for (int i = 0; i <= sum; i++) {
            if(dp[i] >= m){
                ans.add(i);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.get(0));


    }
}


