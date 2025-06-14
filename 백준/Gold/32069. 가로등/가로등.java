import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;


public class Main {

    static Set<Long> visit = new HashSet<>();
    static Queue<long[]> nq = new LinkedList<>();
    static ArrayList<Long> list = new ArrayList<>();
    static long l;

    static void bfs(){
        while(!nq.isEmpty()){
            long[] target = nq.poll();
            long pos = target[0];
            long cost = target[1];

            if(pos-1 >= 0 && !visit.contains(pos - 1)){
                list.add(cost+1);
                visit.add(pos-1);
                nq.add(new long[]{pos - 1,cost + 1});
            }
            if(pos+1 <= l && !visit.contains(pos + 1)){
                list.add(cost+1);
                visit.add(pos+1);
                nq.add(new long[]{pos + 1,cost + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long pos = Long.parseLong(st.nextToken());
            nq.add(new long[]{pos,0});
            visit.add(pos);
            list.add(0L);
        }

        bfs();

        Collections.sort(list);
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }

    }
}


