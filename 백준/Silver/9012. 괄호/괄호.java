import java.util.*;
import java.io.*;



public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stackChar = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());

        int interrupt = 0 ;


        for (int i = 0; i < cnt; i++ ){

            String s = br.readLine();

            for (int j = 0; j < s.length(); j++ ){

                char psp = s.charAt(j);

                if (stackChar.isEmpty() && psp == ')'){

                    sb.append("NO"+"\n");

                    interrupt = 1;

                    break;

                }

                stackChar.push(psp);

                if (!stackChar.isEmpty() && psp == ')'){

                    stackChar.pop();
                    stackChar.pop();

                }

            }

            if (stackChar.isEmpty() && interrupt == 0){

                sb.append("YES"+"\n");

            }else if(interrupt == 0) {

                sb.append("NO"+"\n");

            }

            stackChar.clear();

            interrupt = 0;

        }

        System.out.println(sb);



    }
}
