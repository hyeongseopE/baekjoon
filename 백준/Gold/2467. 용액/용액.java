import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);


        int left = 0;
        int right = list.size()-1;
        int ans = Integer.MAX_VALUE;
        int ansIndex1 = 0;
        int ansIndex2 = 0;
        while(left<right){

            int target = list.get(left)+list.get(right);

            if(target == 0){
                System.out.println(list.get(left)+" "+list.get(right));
                System.exit(0);
            }else if(target > 0){
                if(ans > Math.abs(target)){
                    ans = Math.abs(target);
                    ansIndex1 = left;
                    ansIndex2 = right;
                }
                right --;
            }else if(target < 0){
                if(ans > Math.abs(target)){
                    ans = Math.abs(target);
                    ansIndex1 = left;
                    ansIndex2 = right;
                }
                left ++;
            }
        }

        System.out.println(list.get(ansIndex1)+" "+list.get(ansIndex2));


    }
}
