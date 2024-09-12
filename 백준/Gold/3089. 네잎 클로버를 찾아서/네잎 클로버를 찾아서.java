import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> treeX = new TreeMap<>();
    static TreeMap<Integer, TreeSet<Integer>> treeY = new TreeMap<>();
    static int n, m, ans, cnt;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input ;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            treeX.putIfAbsent(x, new TreeSet<Integer>());
            treeX.get(x).add(y);

            treeY.putIfAbsent(y, new TreeSet<Integer>());
            treeY.get(y).add(x);
        }

        String s = br.readLine();

        Integer x = 0,y = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'U'){
                if(treeY.get(y).higher(x) != null){
                    Integer t = treeY.get(y).higher(x);
                    x = t;
                }
            }
            if(c == 'D'){
                if(treeY.get(y).lower(x) != null){
                    Integer t = treeY.get(y).lower(x);
                    x = t;
                }
            }
            if(c == 'L'){
                if(treeX.get(x).lower(y) != null){
                    Integer t = treeX.get(x).lower(y);
                    y = t;
                }
            }
            if(c == 'R'){
                if(treeX.get(x).higher(y) != null){
                    Integer t = treeX.get(x).higher(y);
                    y = t;
                }
            }
        }

        System.out.println(y+" "+x);
    }
}