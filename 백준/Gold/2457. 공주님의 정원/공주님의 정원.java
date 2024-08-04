import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static class Temp{
        int start;
        int end;
        public Temp(int start, int end){
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Temp> list = new ArrayList<>();
        int x = 0, x1 = 0, cnt = 0, end = 301, maxend = 301;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());

            x = b + a * 100;
            x1 = b1 + a1 * 100;
            if (x1 >= 301) {
                list.add(new Temp(x, x1));
            }

        }

        list.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            } else {
                return o1.start - o2.start;
            }
        });

//        for(Temp t : list){
//            System.out.println(t.start+" "+t.end);
//        }

        boolean ans = false;
        int v = 0;
        while (v < list.size()) {
            boolean found = false;
            while (v < list.size() && list.get(v).start <= end) {
                maxend = Math.max(maxend, list.get(v).end);
                v++;
                found = true;
            }
            if (!found) {
                break;
            }
            end = maxend;
            cnt++;
            if (end > 1130) {
                ans = true;
                break;
            }
        }

        if(ans){
            System.out.println(cnt);
        }else{
            System.out.println(0);
        }

    }
}

