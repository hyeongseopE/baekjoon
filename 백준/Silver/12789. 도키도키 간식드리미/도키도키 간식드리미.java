import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack1 = new Stack<>();

        String dap = "Nice";
        int cnt = 1;
        int n = Integer.parseInt(br.readLine());
        String []s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s[i]);
            if(x != cnt){
                if(!stack1.isEmpty() && stack1.peek() == cnt){
                    cnt ++;
                    i --;
                    stack1.pop();
                }else{
                    stack1.push(x);
                }
            }else{
                cnt ++;
            }
        }

        while(!stack1.isEmpty()){
            int v = stack1.pop();
            if(v == cnt){
                cnt++;
            }else{
                dap = "Sad";
            }
        }
        System.out.println(dap);






    }
}


