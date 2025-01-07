import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int ans = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(!pq.isEmpty() && pq.peek() >= ans){
            ans++;
            pq.add(pq.poll()-1);
            cnt++;
        }

        System.out.println(cnt);



    }
}