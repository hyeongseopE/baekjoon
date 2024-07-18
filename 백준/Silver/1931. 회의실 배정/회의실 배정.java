import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static class Start{

        int start;
        int end;

        public Start(int start, int end){
            this.start = start;
            this.end = end;

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Start> list = new ArrayList<>();
        int cnt = 0;
        int s = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Start(a,b));
        }

        list.sort((o1, o2) -> {
            if (o1.end == o2.end){
                return o1.start - o2.start;
            }else{
                return o1.end - o2.end;
            }
        });

        for (Start start : list){
            if(start.start >= s ){
                s = start.end;
                cnt++;
            }

        }
        System.out.println(cnt);



    }
}


