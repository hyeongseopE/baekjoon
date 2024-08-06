import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (s.isEmpty() || s.peek() < x) {
                s.push(x);
            } else if (s.peek() > x) {
                while (!s.isEmpty() && s.peek() > x) {
                    s.pop();
                    cnt++;
                }
                if (s.isEmpty() || s.peek() != x) {
                    s.push(x);
                }
            }
        }
        while (!s.isEmpty()) {
            if(s.peek() != 0){
                s.pop();
                cnt++;
                continue;
            }
            s.pop();

        }

        System.out.println(cnt);
    }
}