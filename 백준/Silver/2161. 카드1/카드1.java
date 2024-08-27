import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       Queue<Integer> q = new LinkedList<>();
       int n = Integer.parseInt(br.readLine()),cnt=0;

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

       while(q.size() != 1){
           int x = q.poll();
           if(cnt%2!=0){
               q.add(x);
           }else{
               sb.append(x+" ");
           }
           cnt++;
       }

        System.out.println(sb+""+q.poll());

    }
}