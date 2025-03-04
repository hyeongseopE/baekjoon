import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Jem {
        int m,v;
        public Jem(int m, int v ){
            this.m=m;
            this.v=v;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> bag = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Jem> jems = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jems.add(new Jem(w,v));
        }

        for (int i = 0; i < m; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jems,Comparator.comparingInt(o -> o.m));
        Collections.sort(bag);
        PriorityQueue<Integer> ansPq = new PriorityQueue<>(Comparator.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int bagWeight = bag.get(i);

//            System.out.println("가방무개 :"+ bagWeight);
            while(cnt < n && jems.get(cnt).m <= bagWeight ){
//                System.out.println("보석의 무개와 가치 :"+jems.get(cnt).m+","+jems.get(cnt).v);
                ansPq.offer(jems.get(cnt).v);
                cnt ++;
            }

            if(!ansPq.isEmpty()) {
                ans += ansPq.poll();
            }
        }

        System.out.println(ans);

    }
}


