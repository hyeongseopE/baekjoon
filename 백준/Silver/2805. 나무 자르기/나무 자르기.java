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


        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }



        long left = 1;
        long right = Integer.MAX_VALUE;
        long total = 0;
        long ans = 0;

        while(left <= right){

            long mid = (right+left)/2;

            for (int i = 0; i < n; i++) {
                if (list.get(i) > mid){
                    total += (list.get(i) - mid);

                }
            }

            if(total >= m){
                ans = mid;
                left = mid +1;
            }else if(total < m){
                right = mid -1;
            }
            total = 0;

        }

        System.out.println(ans);

    }
}


