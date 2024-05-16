
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long persent = y*100 /x;
        int left = 0, right = 1_000_000_000;
        int ans = -1;

        if (x == y || persent >= 99){
            ans = -1;
        }else{
            while (left <= right){

                int mid = (left + right) / 2;

                long tmpX = x + mid;
                long tmpY = y + mid;

                long persent2 = tmpY * 100 /tmpX;
                // System.out.println("mid="+mid+" left="+left+" right="+right+" persent="+persent+" persent2="+persent2);

                if (persent != persent2){
                    ans = mid;
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }


        System.out.println(ans);


    }
}
