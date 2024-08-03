import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {

    public static class Map {
        int x;
        int y;
        public Map (int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Map> list = new ArrayList<>();
        int t;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Map(a,b));
        }

        list.sort((o1 , o2) -> {
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }else {
                return o1.x - o2.x;
            }
        });


        for (Map map : list) {
            System.out.println(map.x+" "+map.y);
        }

    }
}