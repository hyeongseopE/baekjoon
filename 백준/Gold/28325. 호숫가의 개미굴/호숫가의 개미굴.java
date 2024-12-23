import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            long input = Long.parseLong(st.nextToken());
            ans = ans + input;
            if(input != 0){
                list.add(i);
            }
        }

        if(ans == 0){
            ans = n/2;
        }else{

            for (int i = 0; i < list.size(); i++) {
                int count = 0;
                if(i == list.size()-1){
                    count = (n-list.get(i)+list.get(0))/2;
                    ans += count;
                }else {
                    count = (list.get(i+1) - list.get(i))/2;
                    ans += count;
                }
            }
        }
        System.out.println(ans);





    }
}

