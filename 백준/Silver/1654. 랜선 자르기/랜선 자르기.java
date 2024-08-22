import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int k=0,n=0;
        long ans=0,cnt=0;
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);

        long left=1,right = Collections.max(list);

        while(left <= right){
            long mid = (left+right)/2;
            cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += list.get(i)/mid;
            }

//            System.out.println("left:"+left+" mid:"+mid+" right:"+right+" cnt:"+cnt);

            if(cnt >= n ){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        System.out.println(ans);


    }
}