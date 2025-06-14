import java.io.*;
import java.util.*;

public class Main {

    static Set<Long> visit = new HashSet<>();
    static Queue<long[]> nq = new LinkedList<>();
    static ArrayList<Long> list = new ArrayList<>();
    static long l;
    static int k;

    static void bfs(){
        while(!nq.isEmpty() && list.size() < k){
            long[] target = nq.poll();
            long pos = target[0];
            long cost = target[1];

            if(pos - 1 >= 0 && !visit.contains(pos - 1)){
                list.add(cost + 1);
                visit.add(pos - 1);
                nq.add(new long[]{pos - 1, cost + 1});
            }
            if(pos + 1 <= l && !visit.contains(pos + 1)){
                list.add(cost + 1);
                visit.add(pos + 1);
                nq.add(new long[]{pos + 1, cost + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long pos = Long.parseLong(input[i]);
            if (!visit.contains(pos)) {
                nq.add(new long[]{pos, 0});
                visit.add(pos);
                list.add(0L);
            }
        }

        bfs();

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }
    }
}
