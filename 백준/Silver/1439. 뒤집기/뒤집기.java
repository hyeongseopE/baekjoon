import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        char n = '0';
        boolean check = true;
        int cnt ;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            cnt=0;
            for (int j = 0; j < s.length(); j++) {

                if(s.charAt(j) == Character.forDigit(i,10)){continue;}
                while(true){
                    if(j>=s.length() || s.charAt(j) == Character.forDigit(i,10)){
                        cnt++;
                        break;
                    }
                    j++;
                }
            }
            list.add(cnt);
        }
        Collections.sort(list);

        System.out.println(list.get(0));

    }
}


