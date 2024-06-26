import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String,String> hm1 = new HashMap<>();
        HashMap<String,String> hm2 = new HashMap<>();
        

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            hm1.put(""+i,s);
            hm2.put(s,""+i);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if(hm1.containsKey(input)){
                sb.append(hm1.get(input)+"\n");
            }else if(hm2.containsKey(input)){
                sb.append(hm2.get(input)+"\n");
            }
        }
        

        System.out.println(sb);



    }
}


