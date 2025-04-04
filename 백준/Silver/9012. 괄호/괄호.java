import java.io.*;
import java.util.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == '('){
                    stack.add("(");
                }
                if(input.charAt(j) == ')'){
                    if(stack.size()>0 && stack.peek().equals("(")){
                        stack.pop();
                    }else{
                        stack.add(")");
                    }
                }
            }
            if(stack.isEmpty()){sb.append("YES\n");}
            else{sb.append("NO\n");}
        }

        System.out.println(sb);

    }
}


