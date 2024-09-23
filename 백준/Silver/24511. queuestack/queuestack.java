import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int [] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        StringTokenizer st2;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        arr = new int [n];


        st = new StringTokenizer(br.readLine());
        st2= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st2.nextToken());
            if(Integer.parseInt(st.nextToken()) == 0) {
                arr[cnt++] = x;
            }
        }

        for (int i = cnt-1; i >= 0  ; i--) {
            q.add(arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(q.isEmpty()){
                sb.append(Integer.parseInt(st.nextToken())+" ");
                continue;
            }
            int x = q.poll();
            sb.append(x+" ");
            q.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);


    }
}