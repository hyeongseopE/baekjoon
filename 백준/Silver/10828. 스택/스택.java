
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stackStr = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String input = br.readLine();
            String [] instruction = input.split("\\s");
            switch(instruction[0]){
                case "push":
                    stackStr.push(instruction[1]);
                    break;
                case "top":
                    try{
                        sb.append(stackStr.peek()+"\n");
                    }catch(Exception e){
                        sb.append("-1"+"\n");
                    }

                    break;
                case "size":
                    sb.append(stackStr.size()+"\n");
                    break;
                case "empty":
                    if(stackStr.empty()){
                        sb.append("1"+"\n");
                    }else {
                        sb.append("0"+"\n");
                    }
                    break;
                case  "pop":
                    try{
                        sb.append(stackStr.pop()+"\n");
                    }catch(Exception e){
                        sb.append("-1"+"\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}
