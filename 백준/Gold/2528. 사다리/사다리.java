import java.io.*;
import java.util.*;
import java.util.Stack;


public class Main {
    static Stick []arr;
    static int n,m;

    static class Stick{
        int left,right,d;
        public Stick(int left, int right, int d){
            this.left=left;
            this.right=right;
            this.d=d;
        }

    }

    static void moveStick(int floor){
        for (int i = floor; i < n; i++) {
            Stick s = arr[i];
            if(s.d == 0){
                if(s.right == m){
                    s.left = s.left-1;
                    s.right = s.right-1;
                    s.d = 1;
                }else{
                    s.left = s.left+1;
                    s.right = s.right+1;
                }
            }else{
                if(s.left == 1){
                    s.left = s.left+1;
                    s.right = s.right+1;
                    s.d = 0;
                }else{
                    s.left = s.left-1;
                    s.right = s.right-1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int time = 0;
        int floor = 0;
        arr = new Stick[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d == 0){ arr[i] = new Stick(1,1+(len-1),d);}
            else{ arr[i] = new Stick(m-(len-1),m,d);}
        }

        while(floor < n-1){
            Stick cur = arr[floor];
            Stick next = arr[floor+1];
            if( cur.left > next.right+1 || cur.right < next.left-1 ){
                time ++;
                moveStick(floor);
            }else{
                floor++;
            }
        }

        System.out.println(time);




    }
}


