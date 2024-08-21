import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int find_value=0;
        int c;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            c=0;
            list.clear();
            q.clear();
            int [] arr = new int [x];
            for (int j = 0; j < x; j++) {
                int a = Integer.parseInt(st.nextToken());
                q.add(j);
                list.add(a);
                arr[j] = a;
                if(j == m){
                    find_value = a;
                }
            }
            Collections.sort(list,Collections.reverseOrder());
            while(!q.isEmpty()){
                int s = q.poll();
                if(arr[s] == list.get(c)){
                    c++;
                    if(s == m && arr[s] == find_value){
                        sb.append(c+"\n");
                        break;
                    }
                }else{
                    q.add(s);
                }
            }
        }

        System.out.println(sb);

    }
}