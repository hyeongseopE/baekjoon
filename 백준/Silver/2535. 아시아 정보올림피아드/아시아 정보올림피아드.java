import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        String [] arr = new String[1001];
        int cnt[] = new int [100];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String values[] = input.split(" ");
            String s = values[0]+" "+values[1];
            arr[Integer.parseInt(values[2])] = s;
            list.add(Integer.parseInt(values[2]));
        }
        Collections.sort(list,Collections.reverseOrder());

        int i =0;
        int breakcnt =0;
        while(true){
            if(breakcnt >= 3){break;}
            String s[] = arr[list.get(i)].split(" ");
            int j = Integer.parseInt(s[0]);
            if(cnt[j] > 1){
                i++;
                continue;
            }
            sb.append(arr[list.get(i)]+"\n");
            i++;
            breakcnt++;
            cnt[j]++;
        }

        System.out.println(sb);

    }
}