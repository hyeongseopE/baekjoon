import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static int[] chk = new int[100001];
    static void bfs(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == m) {
                ans = chk[x];
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = x + 1;
                } else if (i == 1) {
                    nx = x - 1;
                } else {
                    nx = x * 2;
                }

                if (nx < 0 || nx >= 100001 ) continue;

                if(i<2 && chk[nx] > chk[x]+1){
                    chk[nx] =chk[x]+1;
                    q.add(nx);
                }else if(i==2&&chk[nx] > chk[x]){
                    chk[nx] = chk[x];
                    q.add(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(chk,Integer.MAX_VALUE);

        chk[n] = 0;
        bfs(n, m);
        System.out.println(ans);
    }
}
