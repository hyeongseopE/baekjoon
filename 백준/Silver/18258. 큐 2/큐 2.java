import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        LinkedList<Integer> list = (LinkedList<Integer>) q;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String []input = br.readLine().split(" ");
            switch(input[0]){
                case "push":
                    q.add(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (q.isEmpty()){
                        sb.append("-1"+"\n");
                    }else {
                        int x = q.poll();
                        sb.append(x+"\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append("1"+"\n");
                    }else {
                        sb.append("0"+"\n");
                    }
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append("-1"+"\n");

                    }else{
                        sb.append(q.peek()+"\n");

                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append("-1"+"\n");
                    }else{
                        sb.append(list.getLast()+"\n");
                    }
                    break;
                default:
                    break;
            }

        }


        System.out.println(sb);

    }
}
