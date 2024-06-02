
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if(!hm.containsKey(s)){
                hm.put(s,1);
            }else{
                hm.put(s, hm.get(s)+1);
            }

        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = st.nextToken();
            if(!hm.containsKey(s)){
                sb.append("0 ");
            }else{
                sb.append(hm.get(s)+" ");
            }

        }
        System.out.println(sb);

    }
}





