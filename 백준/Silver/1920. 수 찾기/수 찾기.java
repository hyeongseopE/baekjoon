import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int ans = 0 ;
        ArrayList<Integer> list = new ArrayList<>();



        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n-1;


            while(left <= right){

                int mid = (right+left)/2;

                if(list.get(mid) == x){
                    ans = 1;
                    break;
                }else if(list.get(mid) > x){
                    right = mid - 1;
                }else if(list.get(mid) < x){
                    left = mid + 1;
                }
            }
            if(ans == 1){
                sb.append("1"+"\n");
            }else{
                sb.append("0"+"\n");
            }
            ans = 0;
        }

        System.out.println(sb);





    }
}


