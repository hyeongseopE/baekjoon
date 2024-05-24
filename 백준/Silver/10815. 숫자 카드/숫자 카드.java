import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        HashSet<Integer> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }


        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (hs.contains(Integer.parseInt(st.nextToken())) ){
                sb.append("1"+" ");
            }else{
                sb.append("0"+" ");
            }
        }

        System.out.println(sb);


    }
}


