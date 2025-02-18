import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int cnt = 0;



        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '.'){
                if(cnt == 0 ){
                    sb.append(".");
                    continue;
                }
                if(cnt % 2 != 0){
                    System.out.println("-1");
                    System.exit(0);;
                }
                for (int j = 0; j < cnt/4; j++) {
                    sb.append("AAAA");
                }
                if(cnt%4 != 0){
                    sb.append("BB");
                }
                sb.append(".");
                cnt = 0;
                continue;
            }
            cnt ++;
        }

        if(cnt != 0 ){
            if(cnt % 2 != 0){
                System.out.println("-1");
                System.exit(0);;
            }
            for (int j = 0; j < cnt/4; j++) {
                sb.append("AAAA");
            }
            if(cnt%4 != 0){
                sb.append("BB");
            }
        }
        System.out.println(sb);


    }
}


