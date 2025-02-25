import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            long countryCnt = 0;
            long country = 0;
            HashMap<Long,Long> hm = new HashMap<>();

            for (int j = 0; j < m; j++) {
                long x = Long.parseLong(st.nextToken());
                long de = 0;
                long cnt = hm.getOrDefault(x,de)+1;
                hm.put(x, cnt);
                if(countryCnt < cnt){
                    countryCnt = cnt;
                    country = x;
                }
            }
            if(countryCnt > m/2){
                sb.append(country+"\n");
            }else{
                sb.append("SYJKGW"+"\n");
            }

        }

        System.out.println(sb);



    }
}


