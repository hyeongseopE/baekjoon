import java.io.*;
import java.util.*;

public class Main {
    static long ans = -1;
    static class T{
        long x , cnt;
        public T(long x,long cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }
    static void bfs(int a,int b){
        Queue<T> q = new LinkedList<>();
        q.add(new T(a,0));
        while(!q.isEmpty()){
             T t = q.poll();

            if(t.x == b){ans = t.cnt;return;}

            long x1 = t.x * 2;
            long x2 = t.x * 10 + 1;



            if(x1 <= b){
                long cnt = t.cnt+1;
                q.add(new T(x1,cnt));
            }
            if(x2 <= b){
                long cnt = t.cnt+1;
                q.add(new T(x2,cnt));
            }



        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bfs(a,b);

        System.out.println((ans == -1) ? -1 : ans+1);





    }
}