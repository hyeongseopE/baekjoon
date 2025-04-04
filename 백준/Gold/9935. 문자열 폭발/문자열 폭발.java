import java.io.*;
import java.util.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
        String find = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            stack.push((s.charAt(i)));
            if(stack.size()-1 >= find.length()-1){
                boolean chk = true;
                for (int j = 0; j < find.length()  ; j++) {
                    if(stack.get(stack.size()-1 - j) != find.charAt(find.length()- 1 - j)){
                        chk = false;
                        break;
                    }
                }
                if(chk){
                    for (int j = 0; j < find.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }

        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
        }
        System.out.println(sb);


    }
}


